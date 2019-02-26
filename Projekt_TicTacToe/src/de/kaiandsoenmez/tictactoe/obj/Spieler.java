package de.kaiandsoenmez.tictactoe.obj;

import java.io.Serializable;
import java.util.ArrayList;

public class Spieler implements Serializable{

	/* Variablendeklaration für die Klasse Spieler */
	private String spielerName = "";
	private int spielerGewinne = 0;
	private int spielerZuege = 0;
	private boolean hatX;
	ArrayList<Integer> feldNummern = new ArrayList<Integer>(); 
	
	public Spieler(String spName, boolean hatX) {
		this.spielerName = spName;
		this.hatX = hatX;
	}
	
	/**
	 * Setzt die Anzahl der gewonnen Spiele eines Spielers
	 * @param gewinne Anzahl der Gesamten Gewinne als Integer
	 */
	public void setGewinne(int gewinne) {
		this.spielerGewinne = gewinne;
	}
	
	/**
	 * Setzt den Boolean ob der Spieler X hat oder nicht 
	 * @param hatX Boolean hat X oder nicht 
	 */
	public void setX(boolean hatX) {
		this.hatX = hatX;
	}
	
	/**
	 * Setzt die Züge für diesen Spieler 
	 * @param zuege Integer Anzahl der gesamten Züge
	 */
	public void setZuege(int zuege) {
		this.spielerZuege = zuege;
	}
	
	/**
	 * Gibt die gesamten Züge des Spielers zurück
	 * @return Integer gesamte Anzahl der Züge
	 */
	public int getZuege() {
		return this.spielerZuege;
	}
	/**
	 * Gibt den Namen des Spielers zurück 
	 * @return SpielerName als String
	 */
	public String getName() {
		return this.spielerName;
	}
	
	/**
	 * Gibt die Anzhal der Gewinne als Integer zurück
	 * @return Integer Anzahl der Gewinne
	 */
	public int getGewinne() {
		return this.spielerGewinne;
	}
	
	/**
	 * Gibt zurück ob der Spieler das Zeichen X hat oder nicht 
	 * @return boolean Ob X oder nicht 
	 */
	public boolean getHatX() {
		return hatX;
	}
	
	public void addFeld(int feldNummer) {
		feldNummern.add(feldNummer);
	}
	
	/**
	 * Gibt die Integer ArrayList zurück 
	 * @return
	 */
	public ArrayList<Integer> getFelder() {
		return feldNummern;
	}

}
