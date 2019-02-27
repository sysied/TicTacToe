package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.kaiandsoenmez.tictactoe.ui.EinstellungSB;

public class MenuSymboleListener implements ActionListener {

	public MenuSymboleListener() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		/* Öffne das Fenster mit den Einstellungen für die Symbole */
		EinstellungSB einst = new EinstellungSB();
		einst.setVisible(true);
		
	}

}
