package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.kaiandsoenmez.tictactoe.obj.Bot;
import de.kaiandsoenmez.tictactoe.obj.Spieler;
import de.kaiandsoenmez.tictactoe.obj.Spielstand;
import de.kaiandsoenmez.tictactoe.obj.TTTButton;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;
import de.kaiandsoenmez.tictactoe.utils.Debug;
import de.kaiandsoenmez.tictactoe.utils.Pruefer;

public class SpielZugListener implements ActionListener {

	/* Variablendeklaration für diese Klasse */
	private boolean setzeX = false;
	private Spieler aktuellerSpieler = null;
	private Spieler zweiterSpieler = null;
	
	/**
	 * Standard Konstruktor der Klasse
	 */
	public SpielZugListener() {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/* Zu Debug Zwecken die globalen statischen Variablen im Hauptfenster ausgeben */
		System.out.println("Spieler " + HauptfensterUI.aktuellerSpieler.getName() + " macht einen ZUG");		
		
		/* Speicher die 2 Spieler Objekte in der Klasse für einen Tausch nach dem Zug */
		this.aktuellerSpieler = HauptfensterUI.aktuellerSpieler;
		this.zweiterSpieler = HauptfensterUI.zweiterSpieler;
		
		/* Aus dem aufrufendem ActionEvent kann man den geklickten Button finden */
		TTTButton klick = (TTTButton) e.getSource();
		if(klick.getTTTZustand() <= 0) {
			/* Das Feld */
			if(HauptfensterUI.aktuellerSpieler.getHatX()) {
				setzeX = true;
			} else {
				setzeX = false;
			}
			
			if(setzeX) {
				System.out.println("Setze X auf dem Feld");
				klick.setTTTZustand(2); //Setzt den Zustand vom Feld auf X
			} else {
				System.out.println("Setze O auf das Feld");
				klick.setTTTZustand(1); //Setzt den Zustand vom Feld auf o
			}
			
			/* Setze dem aufrufendem Spieler einen Zug */
			int zuege = aktuellerSpieler.getZuege();
			aktuellerSpieler.setZuege(zuege + 1);
			aktuellerSpieler.addFeld(klick.getTTTNummer());
			
			/* Prüfe Gewinner ab */
			if(Pruefer.pruefeGewonnen(aktuellerSpieler)) {
				HauptfensterUI.lblStatus.setText(aktuellerSpieler.getName() + " hat gewonnen!");
				HauptfensterUI.disableSpielflaeche();
				return;
			}
			
			/* Prüfe ob der aktuelle Spieler den 5ten Zug macht, wenn Ja unentschieden */
			if(aktuellerSpieler.getZuege() == 5 ) {
				HauptfensterUI.lblStatus.setText("Unentschieden!");
				HauptfensterUI.disableSpielflaeche();
				return;
			}
			
			
			//System.out.println("Hautfenster-Aktueller Spieler wird auf " + zweiterSpieler.getName() + " gestezt");
			//System.out.println("Hautfenster-Zweiter Spieler wird auf " + aktuellerSpieler.getName() + " gestezt");

			/* Ändere die Zugreihenfolge im Hauptfenster */
			HauptfensterUI.aktuellerSpieler = zweiterSpieler;
			HauptfensterUI.zweiterSpieler = aktuellerSpieler;
			
			/* Informiere den benutzer über den Unentschieden Status */
			HauptfensterUI.lblStatus.setText(zweiterSpieler.getName() + " ist am Zug! ");
			
			/* Wenn der Computer als nächstes am Zug ist */
			if(zweiterSpieler.getName().equals("Computer")) {
				Bot pc = new Bot(zweiterSpieler.getName(), false);
				pc.macheZug(HauptfensterUI.spielflaeche);
			}
			
			
		} else {
			/* Das Feld hat schon einen Wert */
			Debug.fehlermeldung("Dieses Feld wurde bereits gewählt, bitte wählen Sie ein leeres Feld!");
		}
		
		
	}

}
