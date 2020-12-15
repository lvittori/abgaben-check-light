# Abgaben-Check (Light-Version) als Basis für Observer

Dieses Projekt überprüft die Abgaben in einem Ordner. **Der Pfad zum Ordner muss in der Klasse Start.java angegeben werden.** Der Name jeder hinzugefügten Datei wird in einer eigenen Klasse (bsp.abgabesys.model.Abgaben) gespeichert, die dann damit die Daten für die entsprechenden Anzeigen liefert. Da Abgaben nicht wieder gelöscht werden sollen, ist dieser Vorgang im System auch nicht abgebildet.

**Projektstruktur**
- bsp.abgabesys.Start: Start-Punkt der Applikation, enthält die main-Methode. **Der Pfad zum überprüften Abgabe-Ordner muss hier angegeben werden**.
- bsp.abgabesys.checker.DirectoryChecker: **Nicht ändern!** Klasse, die den zu überprüfenden Ordner regelmäßig auf neue Dateien abfragt. Das Ergebnis wird in der Klasse abgabesystem.model.Abgaben gespeichert.
- bsp.abgabesys.model.Abgaben: Dieses Klasse abstrahiert die Daten im Ordner und speichert intern die Namen aller abgegebenen Dateien.
- bsp.abgabesys.view.Prozentanzeige: Einfaches Frame für eine Überwachungsanzeige des Ordners. Diese zeigt die Zahl der Abgaben prozentuell in einem Textfeld an.

