package de.kaiandsoenmez.tictactoe.obj;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import de.kaiandsoenmez.tictactoe.utils.Debug;

public class Spielstand implements Serializable{

	/* Variablendeklaration */
	private Spieler aktuellerSpieler = null;
	private Spieler zweiterSpieler = null;
	private String spielstandPfad = "";
	
	/**
	 * Konstruktor des Spielstands
	 * @param aktuellerSpieler Übergibt den aktuellen Spieler der am Zug ist 
	 * @param zweiterSpieler Übergibt den Spieler der danach am Zug ist 
	 */
	public Spielstand(Spieler aktuellerSpieler, Spieler zweiterSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
		this.zweiterSpieler = zweiterSpieler;
	}
	
	/**
	 * Konstruktor, wenn ein Spielstand geladen wird
	 * @param speicherort Speicherort vom Spielstand als String
	 */
	public Spielstand(String speicherort) {
		/* Lade Spielstand */
		ladeSpielstand(speicherort);
	}
	
	/**
	 * Diese Methode speichert den Spielstand in eine Datei
	 * @param speicherort Speicherort der Spielstand Datei
	 */
	public void speicherSpielstand(String speicherort) {
		try {
			/* Datum für den Dateinamen des Spielstands ermitteln */
			String zeit = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			
			/* Hier wird das Spielstand Objekt in eine Datei gespeichert */
			FileOutputStream fos = new FileOutputStream(speicherort + "\\spielstand" + zeit + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos); //Speichert die Datei als Spielstand Objekt 
			
			oos.writeObject(this);
			oos.close();
		} catch(Exception e) {
			e.printStackTrace();
			Debug.fehlermeldung(e.getMessage());
			return;
		}
	}
	
	/**
	 * Diese Methode lädt den Spielstand, wenn der Konstruktor mit dem Speicherpfad benutzt wird 
	 */
	private void ladeSpielstand(String spielstand) {
		try {
			/* Lädt die Datei */
			FileInputStream fis = new FileInputStream(spielstand);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Spielstand speicherStand = (Spielstand) ois.readObject(); //Liest die Datei als Spielstand Objekt 
			ois.close();
			
			//System.out.println("Spielstand mit Aktuellem Spieler: " + speicherStand.aktuellerSpieler.getName() + " und Spieler: " + speicherStand.zweiterSpieler.getName());
			
			/* Speichere den aktuellen Spielstand in dieses Objekt */
			this.aktuellerSpieler = speicherStand.aktuellerSpieler;
			this.zweiterSpieler = speicherStand.zweiterSpieler;
			
		} catch(Exception e) {
			Debug.fehlermeldung(e.getMessage());
			return;
		}
	}
	
	public Spieler getAktuellerSpieler() {
		return this.aktuellerSpieler;
	}
	
	public Spieler getZweiterSpieler() {
		return this.zweiterSpieler;
	}

}
