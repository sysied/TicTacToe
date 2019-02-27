package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

import de.kaiandsoenmez.tictactoe.obj.Spielstand;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;

public class SpielstandListener implements ActionListener{

	/* Variablendeklaration */
	private boolean speichern = false;
	
	/**
	 * Standard Konstruktor, übergibt boolean seichern, um diesen Listener auf 2 Buttons zu legen
	 */
	public SpielstandListener(boolean speichern) {
		this.speichern = speichern;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		/* Starte das Laden oder das Speichern des Spielstands */
		if(speichern) {
			/* Speicher den Spielstand ab */
			Spielstand speicherStand = new Spielstand(HauptfensterUI.aktuellerSpieler, HauptfensterUI.zweiterSpieler);
			
			/* Nach einem Speicherort fragen */
			JFileChooser fcSpeicherOrt = new JFileChooser();
			fcSpeicherOrt.setDialogTitle("Bitte einen Speicherort wählen (Ordner)");
	        fcSpeicherOrt.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
	        fcSpeicherOrt.showSaveDialog(null);

	        //System.out.println(fcSpeicherOrt.getCurrentDirectory());
	        //System.out.println(fcSpeicherOrt.getSelectedFile());
	        
	        speicherStand.speicherSpielstand(fcSpeicherOrt.getSelectedFile().toString());
	        
	        
		} else {
			/* Lade den Spielstand */
			JFileChooser standAuswahl = new JFileChooser();
			standAuswahl.setDialogTitle("Bitte den Spielstand öffnen");
			standAuswahl.setFileSelectionMode(JFileChooser.FILES_ONLY);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("SER-Datei", "*.ser", "ser"); //Erlaubt nur die angegebenen Filter
			standAuswahl.addChoosableFileFilter(filter);
			standAuswahl.setAcceptAllFileFilterUsed(false); //Um SER-Dateien anzuzeigen
			
			
	        int ergebnis;

	        ergebnis = standAuswahl.showOpenDialog(null);

	        /* Wenn der benutzer eine Datei gewählt und bestätigt hat */
	        if (ergebnis == JFileChooser.APPROVE_OPTION) {
	            File file = standAuswahl.getSelectedFile(); //Speichert das ausgewähöte Datei in das File Objekt
	            
	            /* Lade den Spielstand, der ausgewählt wurde */
	            Spielstand ladeStand = new Spielstand(file.getAbsolutePath());
	            
	            HauptfensterUI.aktualisiereSpielflaeche(ladeStand.getAktuellerSpieler(), ladeStand.getZweiterSpieler()); //Überschreibt die Spielfläche mit dem Stand
	            HauptfensterUI.setSpielerNamen(ladeStand.getAktuellerSpieler().getName(), ladeStand.getZweiterSpieler().getName());
	            
	            HauptfensterUI.aktuellerSpieler = ladeStand.getAktuellerSpieler();
	            HauptfensterUI.zweiterSpieler = ladeStand.getZweiterSpieler();
	            
	            /* Setzt das UI auf ein laufendes Spiel */
	            HauptfensterUI.lblStatus.setText("Der Spieler " + ladeStand.getAktuellerSpieler().getName() + " ist am Zug");
	            HauptfensterUI.laufendesSpiel = true;
	            HauptfensterUI.btnStartSpiel.setText("Spiel beenden");
	        }
		}
	}

}
