package de.kaiandsoenmez.tictactoe.ui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import de.kaiandsoenmez.tictactoe.aclt.SpielStartenListener;
import de.kaiandsoenmez.tictactoe.aclt.SpielZugListener;
import de.kaiandsoenmez.tictactoe.obj.Spieler;
import de.kaiandsoenmez.tictactoe.obj.TTTButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionListener;

import javax.swing.JSeparator;

public class HauptfensterUI extends JFrame {

	/**
	 * Deklarieren der globalen Variablen die von andereb Klassen aufgerufen werden
	 */
	private static final long serialVersionUID = 1L;
	
	public static Spieler aktuellerSpieler = null;
	public static Spieler zweiterSpieler = null;
	public static Label lblStatus;
	public static JPanel spielflaeche;
	
	/* Deklarieren von benötigten Variablen des JFrames */
	GridLayout spielflaecheLayout = new GridLayout(3,3);
	Border margin = new EmptyBorder(10,10,10,10);
	
	
	/**
	 * Der Konstruktor dieser Klasse erstellt das Spielfeld
	 */
	public HauptfensterUI() {
		
		/* Eigenschaften des Fensters setzen */
		setResizable(false);
		//setAlwaysOnTop(true);
		setTitle("TicTacToe");
		setBounds(100, 100, 455, 529);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		/* ENDE Eigenschaften setzen */
	
		/* Initialisieren der Objekte die auf das Frame kommen */
		Label lblUeberschriftSpieler = new Label("Spielerverwaltung");
		lblUeberschriftSpieler.setAlignment(Label.CENTER);
		lblUeberschriftSpieler.setBounds(10, 10, 430, 20);
		lblUeberschriftSpieler.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JSeparator trenner = new JSeparator();
		trenner.setBounds(10, 35, 430, 2);
		
		Label lblSpieler1 = new Label("Spieler 1:");
		lblSpieler1.setBounds(10, 50, 150, 25);
		lblSpieler1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		
		Label lblSpieler2 = new Label("Spieler 2:");
		lblSpieler2.setBounds(10, 85, 150, 25);
		lblSpieler2.setFont(new Font("Arial Black", Font.PLAIN, 16));

		
		JTextField ipSpieler1 = new JTextField();
		ipSpieler1.setBounds(170, 50, 240, 25);
		
		JTextField ipSpieler2 = new JTextField();
		ipSpieler2.setBounds(170, 85, 240, 25);
		
		lblStatus = new Label();
		lblStatus.setAlignment(Label.CENTER);
		lblStatus.setBounds(10,150, 429, 24);
		
		JButton btnStartSpiel = new JButton();
		btnStartSpiel.setText("Spiel starten");
		btnStartSpiel.setBounds(170, 120, 240, 25);
		ActionListener startenListener = new SpielStartenListener(ipSpieler1, ipSpieler2);
		btnStartSpiel.addActionListener(startenListener);
		
		
		spielflaeche = new JPanel();
		spielflaeche.setBounds(10, 180, 430, 310);
		spielflaeche.setBackground(Color.WHITE);
		spielflaeche.setBorder(new CompoundBorder(BorderFactory.createTitledBorder("Spielfläche"), margin));
		spielflaeche.setLayout(spielflaecheLayout);
		
		/* ENDE Initialisieren der Objekte die auf das Frame kommen  */
		
		/* Initialisierung der Objekte die auf das Spielfeld kommen 
		 * Banamsung der Buttons: Oben Links l1, Oben Rechts r1 */
		ActionListener szl = new SpielZugListener();
		TTTButton l1 = new TTTButton();
		l1.setTTTNummer(7);
		l1.addActionListener(szl);
		TTTButton m1 = new TTTButton();
		m1.setTTTNummer(8);
		m1.addActionListener(szl);
		TTTButton r1 = new TTTButton();
		r1.setTTTNummer(9);
		r1.addActionListener(szl);
		TTTButton l2 = new TTTButton();
		l2.setTTTNummer(4);
		l2.addActionListener(szl);
		TTTButton m2 = new TTTButton();
		m2.setTTTNummer(5);
		m2.addActionListener(szl);
		TTTButton r2 = new TTTButton();
		r2.setTTTNummer(6);
		r2.addActionListener(szl);
		TTTButton l3 = new TTTButton();
		l3.setTTTNummer(1);
		l3.addActionListener(szl);
		TTTButton m3 = new TTTButton();
		m3.setTTTNummer(2);
		m3.addActionListener(szl);
		TTTButton r3 = new TTTButton();
		r3.setTTTNummer(3);
		r3.addActionListener(szl);
		/* ENDE Initiaisierung der Spielfeld Objekte */

		/* Platzieren der Objekte auf dem Frame */
		getContentPane().add(lblUeberschriftSpieler);
		getContentPane().add(trenner);
		getContentPane().add(lblSpieler1);
		getContentPane().add(lblSpieler2);
		getContentPane().add(ipSpieler1);
		getContentPane().add(ipSpieler2);
		getContentPane().add(btnStartSpiel);
		getContentPane().add(spielflaeche);
		getContentPane().add(lblStatus);
		/* ENDE Platzieren der Objekte auf dem Frame*/
		
		/* Platzieren der Objekte im Spielfeld */
		spielflaeche.add(l1, 0,0);
		spielflaeche.add(m1, 0,1);
		spielflaeche.add(r1, 0,2);
		
		spielflaeche.add(l2, 1,0);
		spielflaeche.add(m2, 1,1);
		spielflaeche.add(r2, 1,2);
		
		spielflaeche.add(l3, 2,0);
		spielflaeche.add(m3, 2,1);
		spielflaeche.add(r3, 2,2);
		/* ENDE Platzieren der Objekte auf dem Spielfeld */
		
		disableSpielflaeche();
		
	}
	
	public static void enableSpielflaeche() {
		for (Component cp : spielflaeche.getComponents() ){
	        cp.setEnabled(true);
		}
	}
	
	public static void disableSpielflaeche() {
		for (Component cp : spielflaeche.getComponents() ){
	        cp.setEnabled(false);
		}
	}
}