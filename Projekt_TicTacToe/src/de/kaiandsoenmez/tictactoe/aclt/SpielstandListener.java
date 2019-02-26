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
	 * Standard Konstruktor
	 */
	public SpielstandListener(boolean speichern) {
		this.speichern = speichern;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		/* Starte das Laden oder das Speichern des Spielstands */
		if(speichern) {
			/* Speicher den Speilstand */
			
		} else {
			/* Lade den Spielstand */
			JFileChooser standAuswahl = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("ser");
			standAuswahl.setFileFilter(filter);
	        int ergebnis;

	        ergebnis = standAuswahl.showOpenDialog(null);

	        /* Wenn der benutzer eine Datei gewählt und bestätigt hat */
	        if (ergebnis == JFileChooser.APPROVE_OPTION) {
	            File file = standAuswahl.getSelectedFile(); //Speichert das ausgewähöte Datei in das File Objekt
	            
	            /* Lade den Spielstand, der ausgewählt wurde */
	            Spielstand ladeStand = new Spielstand(file.getAbsolutePath());
	            
	            HauptfensterUI.aktualisiereSpielflaeche(ladeStand.getAktuellerSpieler(), ladeStand.getZweiterSpieler());
	        }
		}
	}

}
