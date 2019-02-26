package de.kaiandsoenmez.tictactoe.utils;

import java.util.ArrayList;

import javax.swing.JTextField;

import de.kaiandsoenmez.tictactoe.obj.Spieler;

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
			System.out.println("Prüfung auf " + pruefer1 + " & " + pruefer2 + " & " + pruefer3);
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
			System.out.println("Prüfung auf " + pruefer1 + " & " + pruefer2 + " & " + pruefer3);
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
		
		if(feldNummern.contains(3) && feldNummern.contains(5) && feldNummern.contains(7)) {
			return true;
		}
		
		return false;
	}
}
