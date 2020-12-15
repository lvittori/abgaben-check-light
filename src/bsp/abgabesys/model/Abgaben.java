package bsp.abgabesys.model;

import java.util.*;

import bsp.abgabesys.view.Prozentanzeige;

/**
 * Abstrahiert und verwaltet einen Abgabestatus in einem Ordner.
 * @author Lisa Vittori
 * @version 2019-11-30
 */
public class Abgaben {
	private SortedSet<String> dateien;

	// TODO: Diese Verbindung soll in weiterer Folge mit Hilfe des
	// Observer-Patterns erfolgen und damit hier gelöscht werden.
	private Prozentanzeige anzeige;

	/**
	 * Erzeugt ein neues Abgabe-Objekt, das die zugehörige Anzeige
	 * als Parameter bekommt.
	 * @param anzeige die Anzeige, die aktualisiert wird.
	 */
	public Abgaben() {
		dateien = new TreeSet<String>();
	}

	// TODO: Soll in weiterer Folge durch die Möglichkeiten des Observer-
	// Patterns ersetzt und damit hier gelöscht werden.
	/**
	 * Ermöglicht das Setzen des Prozentanzeige-Objekts
	 * @param anzeige Die Prozentanzeige
	 */
	public void setAnzeige(Prozentanzeige anzeige) {
		this.anzeige = anzeige;
	}

	/**
	 * Fügt nur neue Dateien zur bestehenden Liste hinzu.
	 * @param dateien ein Set der Dateien eines Ordners 
	 */
	public void compareAndAdd(Set<String> dateien) {
		// Überprüft, ob neue Dateien im Set sind
		dateien.removeAll(this.dateien);
		if(dateien.size() > 0) {
			// DEBUG-Ausgabe
			System.out.println("ABGABEN: Füge Dateien hinzu");
			this.dateien.addAll(dateien);
			// DEBUG-Ausgabe
			this.testPrint();

			// TODO: Diese Verbindung soll in weiterer Folge mit Hilfe des
			// Observer-Patterns erfolgen und damit hier durch etwas 
			// anderes ersetzt werden.
			if(this.anzeige != null) {
				this.anzeige.aktualisieren(this.dateien.size());
			}
		}
	}

	/**
	 * Testausgabe zum Nachvollziehen der Änderungen
	 */
	public void testPrint() {
		System.out.println("Anzahl an Dateien: " + dateien.size());
		for(String s : dateien) {
			System.out.println(s);
		}
	}
}
