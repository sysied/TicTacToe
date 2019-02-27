package de.kaiandsoenmez.tictactoe.ui;

import java.awt.Color;

import javax.swing.JFrame;

public class EinstellungSB extends JFrame {

	public EinstellungSB() {
		/* Eigenschaften des Fensters setzen */
		setResizable(false);
		//setAlwaysOnTop(true);
		setTitle("Einstellungen"); //Setzt den Titel des JFrame
		setBounds(100, 100, 120, 120);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		/* ENDE Eigenschaften setzen */
		
	}

}
