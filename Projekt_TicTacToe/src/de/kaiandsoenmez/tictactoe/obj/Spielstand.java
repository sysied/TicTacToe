package de.kaiandsoenmez.tictactoe.obj;

public class Spielstand {

	/* Variablendeklaration */
	private Spieler aktuellerSpieler = null;
	private Spieler zweiterSpieler = null;
	
	
	public Spielstand(Spieler aktuellerSpieler, Spieler zweiterSpieler) {
		this.aktuellerSpieler = aktuellerSpieler;
		this.zweiterSpieler = zweiterSpieler;
	}
	
	public Spielstand(String speicherort) {
		/* TODO Lade Spielstand */
	}
	
	public void speicherSpielstand(String speicherort) {
		
	}

}
