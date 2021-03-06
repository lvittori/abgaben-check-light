package bsp.abgabesys.view;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 * Einfache Prozentanzeige
 * @author Lisa Vittori
 * @version 2020-12-15
 */
public class Prozentanzeige extends JFrame{
	private int maxAnzahl;
	private int abgaben;
	private JLabel anzeige;
	private JProgressBar bar;

	/**
	 * Initialisiert eine neue Anzeige auf Basis einer Konsolen-Ausgabe
	 * @param max
	 */
	public Prozentanzeige(int max) {	
		super("Prozentanzeige");
		this.maxAnzahl = max;
		this.abgaben = 0;
		this.anzeige = new JLabel(String.format("Bisher %d von %d Abgaben im Abgabeordner (%.2f", 
				this.abgaben, this.maxAnzahl, this.abgaben*100.0/this.maxAnzahl)+ "%)");
		this.bar = new JProgressBar(0, max);
		this.setBounds(10, 10, 350, 100);
		this.add(this.anzeige, BorderLayout.PAGE_END);
		this.add(this.bar);
		this.setVisible(true);
	}

	/**
	 * Zeigt den bisherigen Stand der Abgaben an.
	 */
	public void anzeigen() {
		this.anzeige.setText(String.format("Bisher %d von %d Abgaben im Abgabeordner (%.2f", 
				this.abgaben, this.maxAnzahl, this.abgaben*100.0/this.maxAnzahl)+ "%)");
		this.bar.setValue(this.abgaben);
	}


	/**
	 * Aktualisiert die Anzeige
	 * @param wert der neue Wert für die Anzeige
	 */
	public void aktualisieren(int wert) {
		this.abgaben = 	wert;
		this.anzeigen();
	}

}
