package de.kaiandsoenmez.tictactoe.obj;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import de.kaiandsoenmez.tictactoe.aclt.SpielerAuswahlListener;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;
import de.kaiandsoenmez.tictactoe.utils.Debug;
import de.kaiandsoenmez.tictactoe.utils.Pruefer;

public class Bot {
	/* Variablendeklaration für diese Klasse */
	private String botName = "";
	private boolean beginn = false;
	
	/**
	 * Standard-Auto Konstruktor
	 */
	public Bot(String name, boolean beginn) {
		this.botName = name;
		this.beginn = beginn;
	}
	
	/**
	 * Lasse den Bot einen Zug auf der mitgegebenen Spielfläche machen
	 * Das JPanel ist die aktuelle Referenz auf das Fahrwerk
	 */
	public void macheZug(JPanel spielfeld) {
		
		System.out.println("Computer ist am ZUG");
		/* 1. Auf eigenen Siegzug prüfen */
		int gewinnZug = Pruefer.kannGewinnen(HauptfensterUI.aktuellerSpieler);
		
		if( gewinnZug != 0) {
			System.out.println("Computer | Gewinnzug " + gewinnZug + " vorhanden");
			/* Es gibt einen Gewinnzug */
			boolean erfolg = klickeButton(gewinnZug, spielfeld);
			if(!erfolg) sucheBestenZug(spielfeld);
			return; //Bricht hier ab
		}
		
		/* 2. Verhindern des gegnerischen Gewinns */
		int gewinnZugGegner = Pruefer.kannGewinnen(HauptfensterUI.zweiterSpieler); //Der zweite Spieler ist wenn der Bot an der Reihe ist der Spieler
		
		if(gewinnZugGegner != 0) {
			System.out.println("Computer | Gegenspieler-Gewinnzug " + gewinnZugGegner + " vorhanden");
			/* Verhindere den gegnerischen Zug */
			boolean erfolg = klickeButton(gewinnZugGegner, spielfeld);
			if(!erfolg) sucheBestenZug(spielfeld);
			return;
		}
		
		/* 3. Mache einen Zug */
		System.out.println("Mache einen normalen Zug");
		sucheBestenZug(spielfeld);
	}
	
	/**
	 * Private Klasse des Bots, um einen Button zu 'drücken'
	 * @param tttButtonNummer Die TTTNummer des zu drückenden Buttons
	 * @param spielfeld Die Referenz auf das Spielfeld
	 */
	private boolean klickeButton(int tttButtonNummer, JPanel spielfeld) {
		for (Component cp : spielfeld.getComponents() ){
			TTTButton feldTTT = (TTTButton) cp; //Castet die Components auf der Spielfläche als TTTButton
			//System.out.println("Durchlauf Feld " + feldTTT.getTTTNummer() + " hat en Zustand " + feldTTT.getTTTZustand());
			
			/* Wenn der Button die mitgegebene TTTNummer hat und nicht schon geklickt wurde, ihn aufrufen und somit klicken */
			if(feldTTT.getTTTNummer() == tttButtonNummer && feldTTT.getTTTZustand() <= 0) {
				System.out.println("Simulierter Button-Klick auf TTTFeld: " + tttButtonNummer);
				ActionListener alFeld = new SpielerAuswahlListener();
				feldTTT.addActionListener(alFeld);
				feldTTT.doClick(); //Führt den ActionListener auf, der den Rest regelt
				return true;
			} else {
				//Nur für DEBUG zwecke
				//System.out.println("Button kann nicht gedrückt werden, starte anderen Zug ");
			}
		}
		
		return false; //Wenn oben nichts gefunden wurde, wird false zurück gegeben
	}
	
	/**
	 * Lässt den Computer ein beliebiges Feld wählen 
	 * @param spielfeld JPanel Spielfeld
	 */
	private void sucheBestenZug(JPanel spielfeld) {
		klickeButton(Pruefer.getBesterZug(HauptfensterUI.aktuellerSpieler, spielfeld), spielfeld);
	}
	

}
