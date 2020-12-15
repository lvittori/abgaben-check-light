package bsp.abgabesys.checker;

import java.io.File;
import java.util.*;

import bsp.abgabesys.model.Abgaben;
/**
 * NICHT ÄNDERN!!!
 * Kann von einem Timer benutzt werden, um regelmäßig einen Ordner
 * abzufragen. Die generierte Liste wird als Set an das zuständige
 * Abgaben-Objekt übergeben.
 * @author Lisa Vittori
 * @version 2019-11-30
 */
public class DirectoryChecker extends TimerTask {
  private File toCheck;
  private Abgaben abgaben;

  /**
   * Erstellt den Checker für das übergebene File-Objekt und
   * dem entsprechenden Abgaben-Objekt
   * @param f Der überwachte Ordner
   * @param abgaben Das Objekt, das die Daten des Ordners verwaltet
   */
  private DirectoryChecker(File f, Abgaben abgaben) {
    this.toCheck = f;
    this.abgaben = abgaben;
  }
  
  /**
   * Überprüft den als Attribut gespeicherten Ordner
   */
  @Override
  public void run() {
    // DEBUG-Ausgabe zum Nachvollziehen des Ablaufes
    System.out.println("DIRECTORYCHECKER: Checking " + toCheck.getAbsolutePath());
    String[] dateien = toCheck.list();
    TreeSet<String> ts = new TreeSet<String>();
    Collections.addAll(ts, dateien);
    // Entfernen von System-Einträgen
    ts.remove(".");
    ts.remove(".DS_Store");
    abgaben.compareAndAdd(ts);
  }
  
  /**
   * Startet einen Timer zur Überwachung eines Ordners. Das Ergebnis der
   * Überwachung wird im Abgaben-Objekt verwaltet
   * @param f der überwachte Ordner
   * @param a das Abgaben-Objekt zur Verwaltung der Abgabe-Daten
   * @param seconds das Intervall, in dem der Abgabe-Ordner abgefragt wird
   *    (in Sekunden).
   * @return das Timer-Objekt zur Steuerung der Überwachung
   */
  public static Timer start(File f, Abgaben a, int seconds) {
    Timer t = new Timer("Checking " + f.getName());
    DirectoryChecker dc = new DirectoryChecker(f, a);
    t.scheduleAtFixedRate(dc, 100, seconds*1000);
    return t;
  }

}
