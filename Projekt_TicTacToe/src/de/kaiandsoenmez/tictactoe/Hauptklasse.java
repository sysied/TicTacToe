package de.kaiandsoenmez.tictactoe;

import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;

public class Hauptklasse {

	/**
	 * Diese Hauptklasse startet das Programm
	 * @param args
	 */
	public static void main(String[] args) {
		/* Überprüfung ob ein alter Spielstand verfügbar ist TODO */
		
		/* Laden des Spielstands TODO */
		
		/* Initialisiert das Hauptfenster */
		HauptfensterUI fenster = new HauptfensterUI(); //Erstellt ein Fenster Objekt 
		fenster.setVisible(true); //Macht das Fenster sichtbar
		System.out.println("Starte das Spielefenster");
	}

}
