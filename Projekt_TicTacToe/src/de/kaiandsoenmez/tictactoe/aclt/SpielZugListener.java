package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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
		System.out.println("Der aktuelle Spieler ist " + HauptfensterUI.aktuellerSpieler.getName());
		System.out.println("Der zweite Spieler ist " + HauptfensterUI.zweiterSpieler.getName());
		
		
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
				klick.setTTTZustand(2);
			} else {
				klick.setTTTZustand(1);
			}
			
			/* Setze dem aufrufendem Spieler einen Zug */
			int zuege = aktuellerSpieler.getZuege();
			aktuellerSpieler.setZuege(zuege + 1);
			aktuellerSpieler.addFeld(klick.getTTTNummer());
			
			/* Prüfe Gewinner ab */
			if(Pruefer.pruefeGewonnen(aktuellerSpieler)) {
				HauptfensterUI.lblStatus.setText("Der Spieler " + aktuellerSpieler.getName() + " hat gewonnen!");
				HauptfensterUI.disableSpielflaeche();
				return;
			}
			
			/* Prüfe ob der aktuelle Spieler den 5ten Zug macht, wenn Ja unentschieden */
			if(aktuellerSpieler.getZuege() == 5 ) {
				HauptfensterUI.lblStatus.setText("Unentschieden!");
				HauptfensterUI.disableSpielflaeche();
				return;
			}
			
			/* Ändere die Zugreihenfolge im Hauptfenster */
			HauptfensterUI.aktuellerSpieler = zweiterSpieler;
			HauptfensterUI.zweiterSpieler = aktuellerSpieler;
			
			HauptfensterUI.lblStatus.setText("Der Spieler " + zweiterSpieler.getName() + " ist am Zug! ");
			
		} else {
			/* Das Feld hat schon einen Wert */
			Debug.fehlermeldung("Dieses Feld wurde bereits gewählt, bitte wählen Sie ein leeres Feld!");
		}
		
		
	}

}
