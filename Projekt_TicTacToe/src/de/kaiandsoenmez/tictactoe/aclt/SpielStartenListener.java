package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

import de.kaiandsoenmez.tictactoe.obj.Bot;
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
		
		/* Caste aus dem ActionEvent um  auf den Button zuzugreifen */
		JButton spielStartenButton = (JButton) arg0.getSource();
		
		/* Prüfen ob ein Spiel läuft und beendet werden muss */
		if(HauptfensterUI.laufendesSpiel) {
			HauptfensterUI.laufendesSpiel = false;
			spielStartenButton.setText("Spiel starten");
			HauptfensterUI.leereSpielflaeche();
			return;
		}
		
		/* Überprüfen ob beide Speieler eingegeben wurden */
		if(Pruefer.pruefeInputText(i1) && Pruefer.pruefeInputText(i2)) {
			/* Erstelle die beiden Spieler */
			Spieler ersterSpieler = null;
			Spieler zweiterSpieler = null;
			
			
			int zufallsZahl = zufall.nextInt(50); //Generiert eine Zufallszahl zwischen 1 - 49
			if(zufallsZahl >= 25) { /* Wenn der Zufallswert größer gleih 25 ist, wird der Spieler per Zufall gewechselt */
				
				/* Erstelle den ersten Spieler und weise es der Statischen Variable im Hauptfenster zu */
				ersterSpieler = new Spieler(i1.getText(), true);
				zweiterSpieler = new Spieler(i2.getText(), false);

			} else {
				
				/* Erstelle den ersten Spieler und weise es der Statischen Variable im Hauptfenster zu */
				ersterSpieler = new Spieler(i2.getText(), true);
				zweiterSpieler = new Spieler(i1.getText(), false);

			}
			
			/* Benachrichtige den Benutzer, wer anfängt */
			HauptfensterUI.lblStatus.setText(ersterSpieler.getName() + " hat X und beginnt");
			
			/* Weist den globalen statischen Variablen im Hauptfenster die Spieler zu */
			HauptfensterUI.aktuellerSpieler = ersterSpieler;
			HauptfensterUI.zweiterSpieler = zweiterSpieler;
			
			HauptfensterUI.enableSpielflaeche();
			
			if(HauptfensterUI.aktuellerSpieler.getName().equals("Computer")) {
				Bot pc = new Bot(ersterSpieler.getName(), true);
				pc.macheZug(HauptfensterUI.spielflaeche);
			}
			
			/* Ändere die Funktion des Buttons um, um das Spiel zu beenden */
			HauptfensterUI.laufendesSpiel = true;
			spielStartenButton.setText("Spiel beenden");
			
		} else {
			/* Werfe eine Fehlermeldung, die dem Benutzer signalisiert, dass kein Text für den Spieler eingegeben wurde */
			Debug.fehlermeldung("Bitte geben Sie beide Spielernamen ein!");
			return;
		}
		
		
	}

}
