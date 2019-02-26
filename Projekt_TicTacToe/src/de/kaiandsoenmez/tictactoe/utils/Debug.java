package de.kaiandsoenmez.tictactoe.utils;

import javax.swing.JOptionPane;

public class Debug {
	public static void fehlermeldung(String text) {
		JOptionPane.showMessageDialog(null, text, "Fehlermeldung", JOptionPane.ERROR_MESSAGE);
	}
}
