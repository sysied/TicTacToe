package de.kaiandsoenmez.tictactoe.aclt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import de.kaiandsoenmez.tictactoe.obj.TTTButton;
import de.kaiandsoenmez.tictactoe.ui.HauptfensterUI;

public class SpielerAuswahlListener implements ActionListener {

	public SpielerAuswahlListener() {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			JComboBox auswahlBox = (JComboBox) arg0.getSource();
			
			if(auswahlBox.getSelectedIndex() == 1 ) {
				HauptfensterUI.computerSpiel = true;
				HauptfensterUI.ipSpieler2.setText("Computer");
				HauptfensterUI.ipSpieler2.setEnabled(false);
				
			} else  if(auswahlBox.getSelectedIndex() == 0) {
				HauptfensterUI.computerSpiel = false;
				HauptfensterUI.ipSpieler2.setText("");
				HauptfensterUI.ipSpieler2.setEnabled(true);
			}
		} catch(Exception e) {
			System.out.println("Fehler aufgetreten " + e.getMessage());
		}
		
	}

}
