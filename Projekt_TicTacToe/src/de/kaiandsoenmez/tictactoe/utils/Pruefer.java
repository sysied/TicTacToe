package de.kaiandsoenmez.tictactoe.utils;

import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;

import de.kaiandsoenmez.tictactoe.obj.Spieler;
import de.kaiandsoenmez.tictactoe.obj.TTTButton;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;

public class Pruefer {
	
	/**
	 * Prüft ob der Spieler einen korrekten Namen hat
	 * @param spieler Übergibt das Spielerobjekt 
	 * @return Gibt zurück ob der Spieler einen korrekten Namen hat 
	 */
	public static boolean pruefeSpieler(Spieler spieler) {
		return !spieler.getName().equals("");
	}
	
	/**
	 * Prüft ob das TextFeld einen Inhalt hat
	 * @param input TextFeld Objekt
	 * @return Gibt zurück ob das TextFeld Inhalt hat 
	 */
	public static boolean pruefeInputText(JTextField input) {
		return !input.getText().equals("");
	}
	
	/**
	 * Diese Methode prüft ob ein Spieler die Gewinnbedingungen erfüllt 
	 * @param spieler Zu übergebendes Spieler Objekt, dass zu prüfen ist
	 * @return Gibt zurück ob dieser Spieler gewonnen hat 
	 */
	public static boolean pruefeGewonnen(Spieler spieler) {
		ArrayList<Integer> feldNummern = spieler.getFelder();
		int pruefer1 = 1;
		int pruefer2 = 2;
		int pruefer3 = 3;
		
		/* Überprüfen auf Horizontale Gewinnreihenfolge */
		for(int i = 0; i <= 2; i++) {
			//System.out.println("Prüfung auf " + pruefer1 + " & " + pruefer2 + " & " + pruefer3);
			if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer2) && feldNummern.contains(pruefer3)) {
					return true;
			}
				pruefer1 += 3;
				pruefer2 += 3;
				pruefer3 += 3;
			
		}
		
		/* Setze die Prüfer für eine neue Schleife zurück */
		pruefer1 = 1;
		pruefer2 = 4;
		pruefer3 = 7;
		
		/* Überprüfen auf Verticale Gewinnreihenfolge */
		for(int i = 0; i <= 2; i++) {
			//System.out.println("Prüfung auf " + pruefer1 + " & " + pruefer2 + " & " + pruefer3);
			if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer2) && feldNummern.contains(pruefer3)) {
					return true;
			}
				pruefer1 += 1;
				pruefer2 += 1;
				pruefer3 += 1;
			
		}
		
		/* Überprüfen auf Quere Gewinnreihenfolge */
		if(feldNummern.contains(1) && feldNummern.contains(5) && feldNummern.contains(9)) {
			return true;
		}
		/* Überprüft auf Queren Treffer, Rechts Oben, Mitte, Links Unten */
		if(feldNummern.contains(3) && feldNummern.contains(5) && feldNummern.contains(7)) {
			return true;
		}
		
		/* Wenn kein Sieg, gebe false zurück */
		return false;
	}
	
	/**
	 * Prüft ob der Spieler einen Gewinnzug machen kann 
	 * @param spieler Zu überprüfendes Spieler Objekt
	 * @return Gibt das TicTacToe Feld zurück mit dem der Spieler gewinnen kann
	 */
	public static int kannGewinnen(Spieler spieler) {
		ArrayList<Integer> feldNummern = spieler.getFelder(); //Lädt die gewählten Felder eines Spielers
		
		System.out.println("Kann Gewinnen Prüfung für Spieler " + spieler.getName() + " -----");
		for(int zahl : feldNummern) {
			System.out.println("Zahl: " + zahl);
		}
		System.out.println("-------------------");
		
		
		/* Prüfe auf Diagonale Gewinne */
		if(feldNummern.contains(1) && feldNummern.contains(5)) {
			return 9; //Zeile wird mit 9 beendet
		}
		if(feldNummern.contains(1) && feldNummern.contains(9)) {
			return 5; //Zeile wird mit 5 beendet
		}
		if(feldNummern.contains(9) && feldNummern.contains(5)) {
			return 1; //Zeile wird mit 1 beendet
		}
		
		
		/* Variablen für die Schleife der Horizontalen und Verticalen  prüfung */
		int pruefer1 = 1;
		int pruefer2 = 2;
		int pruefer3 = 3;
		
		/* Überprüfen auf Horizontale Gewinnmöglichkeit */
		for(int i = 0; i <= 2; i++) {
		//	if(feldNummern.contains(pruefer1) || feldNummern.contains(pruefer2) || feldNummern.contains(pruefer3)) {
				System.out.println("Prüfung ");
				if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer2)) {
					if(pruefeTTTButton(pruefer3, HauptfensterUI.spielflaeche)) return pruefer3; //Zeile wird mit 3 beendet
					
				}
				if(feldNummern.contains(pruefer2) && feldNummern.contains(pruefer3)) {
					System.out.println("");
					if(pruefeTTTButton(pruefer1, HauptfensterUI.spielflaeche)) return pruefer1; //Zeile wird mit 1 beendet
				}
				if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer3)) {
					if(pruefeTTTButton(pruefer2, HauptfensterUI.spielflaeche)) return pruefer2; //Zeile wird mit 2 beendet
				}
		//	}
			
			/* Zähle die Variablen hoch, Überprüfe somit die nächste Zeile */
			pruefer1 += 3;
			pruefer2 += 3;
			pruefer3 += 3;
			
		} //ENDE For-Each
		
		/* Setze die Prüfer für eine neue Verticale Schleife zurück */
		pruefer1 = 1;
		pruefer2 = 4;
		pruefer3 = 7;
		
		/* Überprüfen auf Verticale Gewinnmöglichkeit */
		for(int i = 0; i <= 2; i++) {
			//if(feldNummern.contains(pruefer1) || feldNummern.contains(pruefer2) || feldNummern.contains(pruefer3)) {
				if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer2)) {
					if(pruefeTTTButton(pruefer3, HauptfensterUI.spielflaeche)) return pruefer3; //Zeile wird mit 2 beendet
				}
				if(feldNummern.contains(pruefer2) && feldNummern.contains(pruefer3)) {
					if(pruefeTTTButton(pruefer1, HauptfensterUI.spielflaeche)) return pruefer1; //Zeile wird mit 2 beendet
				}
				if(feldNummern.contains(pruefer1) && feldNummern.contains(pruefer3)) {
					if(pruefeTTTButton(pruefer2, HauptfensterUI.spielflaeche)) return pruefer2; //Zeile wird mit 2 beendet
				}
		//	}
			
			/* Zähle die Variablen hoch, Überprüfe somit die nächste Zeile */
			pruefer1 += 1;
			pruefer2 += 1;
			pruefer3 += 1;
			
		} //ENDE For-Each
		
		
		
		/* Wenn keine Gewinnmöglichkeit ermittelt wurde wird 0 zurück gegeben */
		return 0;
	}
	
	/**
	 * TODO Mehr Logik
	 * @param spieler Zu Übergebendes Spielerobjekt 
	 * @param spielfeld Referenz auf das aktuelle Spielfeld
	 * @return Gibt die Nummer des besten TTTButton Feldes zurück 
	 */
	public static int getBesterZug(Spieler spieler, JPanel spielfeld) {
		/* Gehe über jedes Feld und suche die leeren Felder */
		for(int i = 0; i <= 9; i++) {
			if(pruefeTTTButton(i, spielfeld)) return i;
		}
		
		return 0;
	}
	
	private static boolean pruefeTTTButton(int tttButtonNummer, JPanel spielfeld) {
		System.out.println("Prüfe auf TTTKlick bei Feld " + tttButtonNummer);
		for (Component cp : spielfeld.getComponents() ){
			TTTButton feldTTT = (TTTButton) cp; //Castet die Components auf der Spielfläche als TTTButton
			
			/* Wenn der Button die mitgegebene TTTNummer hat und nicht schon geklickt wurde, false zurückgeben */
			if(feldTTT.getTTTNummer() == tttButtonNummer && feldTTT.getTTTZustand() <= 0) {
				System.out.println("Feld " + tttButtonNummer + " ist frei TRUE");
				return true;
			}
		} //ENDE For-Each
		
		/* Wenn der Button belegt ist, gebe False zurück */
		return false;
	}
	
}
