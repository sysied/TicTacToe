package de.kaiandsoenmez.tictactoe.obj;

import javax.swing.JButton;

public class TTTButton extends JButton {

	/* Die JButton Klasse wird mit einer von uns benötigten Variable erweitert */
	private int tttNummer = 0;
	private int tttZustand = 0; //1 = Kreis, 2 = Kreuz
	
	/**
	 * Überschreibt den Standard Konstruktor der Klasse 'JButton'
	 * @param text
	 */
	public TTTButton(String text) {
		super(text);
		
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(true);
		this.setFocusPainted(false);
	}
	
	public TTTButton() {
		super();
		
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(true);
		this.setFocusPainted(false);
	}
	
	/**
	 * Setzt die Spielflächen Nummer unseres Buttons 
	 * @param nummer Integer Nummer des Buttons auf der Spielfläche
	 */
	public void setTTTNummer(int nummer) {
		this.tttNummer = nummer;
	}
	
	/**
	 * Setzt den Zustand, also ob als Kreis oder als Kreuz markiert wurde 
	 * @param zustand
	 */
	public void setTTTZustand(int zustand) {
		if(zustand == 1) {
			/* Wenn der Zustand Kreis ist, setzte für den Button das Kreis Bild */
			this.setText("O");
			this.tttZustand = 1;
		} else if(zustand == 2) {
			/* Wenn der Zustand Kreuz ist, setze für den Button das Kreuz Bild */
			this.setText("X");
			this.tttZustand = 2;
		}
	}
	
	/**
	 * Gibt die Spielflächennummer des Buttons zurück 
	 * @return Gibt den Integer Spielflächennummer zurück 
	 */
	public int getTTTNummer() {
		return this.tttNummer;
	}
	
	public int getTTTZustand() {
		return this.tttZustand;
	}

}
