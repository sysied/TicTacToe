package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JTextField;

import de.kaiandsoenmez.tictactoe.obj.Spieler;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;
import de.kaiandsoenmez.tictactoe.utils.Debug;
import de.kaiandsoenmez.tictactoe.utils.Pruefer;

public class SpielStartenListener implements ActionListener {
	/* Deklariere Private Variablen für diese Klasse */
	JTextField i1 = null;
	JTextField i2 = null;
	//Label status = null;
	Random zufall = new Random();
	boolean spieler1Startet = false;
	
	/**
	 * Der Standard Konstruktor dieses ActionListeners 
	 */
	public SpielStartenListener(JTextField i1, JTextField i2) {
		this.i1 = i1;
		this.i2 = i2;
		//this.status = lblStatus;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Überprüfen ob beide Speieler eingegeben wurden */
		if(Pruefer.pruefeInputText(i1) && Pruefer.pruefeInputText(i2)) {
			
			/* Erstelle die beiden Spieler */
			int zufallsZahl = zufall.nextInt(50); //Generiert eine Zufallszahl zwischen 1 - 49
			if(zufallsZahl >= 25) { /* Wenn der Zufallswert größer gleih 25 ist, wird der Spieler per Zufall gewechselt */
				System.out.println("Speieler 1 beginnt...");
				spieler1Startet = true;
				HauptfensterUI.lblStatus.setText("Spieler " + i1.getText() + " hat X und den ersten Zug!");
				HauptfensterUI.lblStatus.repaint();
				
				/* Erstelle den ersten Spieler und weise es der Statischen Variable im Hauptfenster zu */
				Spieler ersterSpieler = new Spieler(i1.getText(), true);
				Spieler zweiterSpieler = new Spieler(i2.getText(), false);

				/* Setzt die Spieler des aktuellen Spiels im Hauptfenster */
				HauptfensterUI.aktuellerSpieler = ersterSpieler;
				HauptfensterUI.zweiterSpieler = zweiterSpieler;
				
			} else {
				System.out.println("Spieler 2 beginnt...");
				HauptfensterUI.lblStatus.setText("Spieler " + i2.getText() + " hat X und den ersten Zug!");
				HauptfensterUI.lblStatus.repaint();
				
				/* Erstelle den ersten Spieler und weise es der Statischen Variable im Hauptfenster zu */
				Spieler ersterSpieler = new Spieler(i2.getText(), true);
				Spieler zweiterSpieler = new Spieler(i1.getText(), false);

				HauptfensterUI.aktuellerSpieler = ersterSpieler;
		        HauptfensterUI.zweiterSpieler = zweiterSpieler;
			}
			
			/* Aktiviert die Spielfläche und erlaubt die EIngabe */
			HauptfensterUI.enableSpielflaeche();
			
		} else {
			/* Werfe eine Fehlermeldung, die dem Benutzer signalisiert, dass kein Text für den Spieler eingegeben wurde */
			Debug.fehlermeldung("Bitte geben Sie Spielernamen ein!");
			return;
		}
		
		
	}

}
