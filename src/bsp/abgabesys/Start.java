package bsp.abgabesys;

import java.io.File;
import java.util.Timer;

import javax.swing.JOptionPane;

import bsp.abgabesys.checker.DirectoryChecker;
import bsp.abgabesys.model.Abgaben;
import bsp.abgabesys.view.Prozentanzeige;
/**
 * Startpunkt der Applikation. Legt das Ordner-Objekt fest und startet
 * die Überwachung
 * @author Lisa Vittori
 * @version 2019-11-30
 */
public class Start {
	//TODO: Pfad zur Datei angeben, die überwacht werden soll-
	public static String ordner = "./Ueberwacht";
	
	public static void main(String[] args) {
		File f = new File(ordner); // überwachter Ordner
		if(f.exists() && f.isDirectory()) {

			// Initialisierung des Datenobjekts für die Abgabe (Subjekt). Dieses Objekt soll dann
			// die Benachrichtigungen für alle Anzeigen (Observer) ausschicken, sobald sich etwas
			// an seinem Status ändert
			// TODO: Die Klasse Abgaben so ändern, dass sie dem Observer-Pattern entspricht
			Abgaben abgaben = new Abgaben();
			// Anzeige (Observer) für das Abgaben-Objekt
			// TODO: Die Anzeige-Klasse so ändern, dass sie dem Observer-Pattern entspricht
			Prozentanzeige anz  = new Prozentanzeige(27);


			// Ausgabe zum Überprüfen des Ablaufes
			System.out.println("Starte Überwachung von " + f.getAbsolutePath());

			// DO NOT TOUCH: Hier wird die Überwachung des Verzeichnisses gestartet und das 
			// Abgaben-Objekt initialisiert, sobald sich etwas im Überwachten Pfad ändert
			Timer ueberwachung = DirectoryChecker.start(f, abgaben, 3);

			// Steuerung
			String msg = "Welche Aktion soll durchgeführt werden?\n(Cancel/Abbrechen für Ende)";
			String[] opts = {"Prozentanzeige anmelden", "Prozentanzeige abmelden"};

			Object sel = JOptionPane.showInputDialog(null, msg, "Auswahl", JOptionPane.QUESTION_MESSAGE, null,
					opts, "Prozentanzeige anmelden");
			// Registrierung von Anzeigen
			while(sel != null) {
				String s = sel.toString();
				switch(s) {
				case "Prozentanzeige anmelden":
					// TODO: Über das Observer-Pattern registrieren
					abgaben.setAnzeige(anz);
					break;
				case "Prozentanzeige abmelden":
					// TODO: Über das Observer-Pattern abmelden
					abgaben.setAnzeige(null);
					break;
				}
				sel = JOptionPane.showInputDialog(null, msg, "Auswahl", JOptionPane.QUESTION_MESSAGE, null,
						opts, "Prozentanzeige abmelden");
			}

			ueberwachung.cancel();
			System.exit(0);
		}
	}
}
