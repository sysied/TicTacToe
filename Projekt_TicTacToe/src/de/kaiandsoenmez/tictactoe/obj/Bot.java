package de.kaiandsoenmez.tictactoe.obj;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;

import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;
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
		System.out.println("Aktueller Spieler Hauptfenster = " + HauptfensterUI.aktuellerSpieler.getName());
		/* 1. Auf eigenen Siegzug prüfen */
		int gewinnZug = Pruefer.kannGewinnen(HauptfensterUI.aktuellerSpieler);
		
		if( gewinnZug != 0) {
			System.out.println("Gewinn Zug vorhanden: " + gewinnZug);
			/* Es gibt einen Gewinnzug */
			klickeButton(gewinnZug, spielfeld);
			return; //Bricht hier ab
		}
		
		/* 2. Verhindern des gegnerischen Gewinns */
		int gewinnZugGegner = Pruefer.kannGewinnen(HauptfensterUI.zweiterSpieler); //Der zweite Spieler ist wenn der Bot an der Reihe ist der Spieler
		
		if(gewinnZugGegner != 0) {
			System.out.println("Gewinn Zug Gegner Blocken: " + gewinnZugGegner);
			/* Verhindere den gegnerischen Zug */
			klickeButton(gewinnZugGegner, spielfeld);
			return;
		}
		
		/* 3. Mache einen Zug */
		System.out.println("Mache Einen Zug");
		System.out.println("Zug für TTTButton " + Pruefer.getBesterZug(HauptfensterUI.aktuellerSpieler, spielfeld));
		klickeButton(Pruefer.getBesterZug(HauptfensterUI.aktuellerSpieler, spielfeld), spielfeld);
		
	}
	
	/**
	 * Private Klasse des Bots, um einen Button zu 'drücken'
	 * @param tttButtonNummer Die TTTNummer des zu drückenden Buttons
	 * @param spielfeld Die Referenz auf das Spielfeld
	 */
	private void klickeButton(int tttButtonNummer, JPanel spielfeld) {
		for (Component cp : spielfeld.getComponents() ){
			TTTButton feldTTT = (TTTButton) cp; //Castet die Components auf der Spielfläche als TTTButton
			
			/* Wenn der Button die mitgegebene TTTNummer hat und nicht schon geklickt wurde, ihn aufrufen und somit klicken */
			if(feldTTT.getTTTNummer() == tttButtonNummer && feldTTT.getTTTZustand() <= 0) {
				System.out.println("Klick für Button " + tttButtonNummer);
				feldTTT.doClick(); //Führt den ActionListener auf, der den Rest regelt
			}
		}
	}
	

}
