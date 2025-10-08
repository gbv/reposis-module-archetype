# reposis-module-archetype

Ein Template für alle Reposis-Anwendungen als maven-archetype.

## reposis-modul in jar umstellen

### Archtype bauen, damit man ihn lokal einsetzen kann:
* reposis-module-archetype auschecken
* `mvn clean install`

### Maven Projekt erstellen
* reposis-Projekt, welches migriert oder neu erstellt werden soll, auschecken und neue Struktur anlegen (hier am Beispiel "francke")
  * `mvn archetype:generate -Dfilter=reposis-module-archetype`
    * Auswahl meist 1 (local: reposis-module-archetype)
    * `projectName: francke`
    * `groupId: de.gbv.reposis`
    * `artifactId: reposis_francke`
    * `package: de.gbv.reposis` (default)
    * `version: 2025.06-SNAPSHOT` (matching MyCoRe-Version)
  * erstellt `reposis_francke` mit entsprechender Struktur
  * die `gitignore` Datei muss noch in `.gitignore` umbenannt werden. (liegt an einem Bug in Maven)

### Dateien (bei Migration)

* Kopieren von `save/webpages/` zu `src/main/resources/META-INF/resources/`
* Kopieren von `resources/` zu `src/main/resources`
* Vorerst löschen von `resources/log4j2.xml`
* Properties
  * Es muss unterschieden werden in Properties die nur für das Test oder Produktiv-System sind, oder welche die für alle Allg. sind
  * Nur die allg. Properties sollten in dem Modul enthalten sein

### Allgemeines
  * `setup-reposis_francke.txt` → enthält CLI-Befehle z.B. anpassen von Klassifikation die nur für diese Anwendung benötigt werden
  * `CI=true mvn clean install` → baut analog zu GitHub, benötigt lokal installierten WebDriver
  * einfacher Seleniumtest zum Prüfen ob Anwendung noch startet → wichtig, muss mit IT enden! (z.B. https://github.com/gbv/reposis_digibib/blob/2021.06/src/test/java/de/vzg/reposis/digibib/DigibibLibIT.java)

### Verzeichnissstruktur 

  * src/
    * main/ - Alle Dateien die später im Jar Laden
      * java/ - Enthält Java Code speziell für diese Anwendung
      * resources/ - Resourcen die über den "Classpath" zur verfügung stehen
      * META-INF/resources - Web Resourcen welche im Kontext der Anwedung abrufbar sind
    * test/ - Alle Dateien für das Testen der Anwendung
      * java/ - Enthält Java Code zum Testen der Anwendung  

## Troubleshooting
* `mvn clean install -Pauto-update`   → sortiert pom.xml
* `CI=true mvn solr-runner:stop`      → stoppt GitHub-Solr im Falle eines Test-Fehlers 




---

## Grundkonfiguration

1. **`oai-eprints.xml` einrichten**  
   Diese Datei definiert die OAI-PMH-Eprints-Konfiguration.  
   Achte darauf, dass sie dem erwarteten Schema und den Repository-Richtlinien entspricht.

2. **`oai-rights.xml` einrichten**  
   In dieser Datei werden die Rechte- und Zugriffsinformationen für die OAI-Datensätze festgelegt.  
   Passe sie an die Lizenz- und Zugriffsrichtlinien deines Repositories an.

3. **`mycore.properties` konfigurieren**  
   - Verwende die bereitgestellte Vorlage als Ausgangspunkt:  
    
    > mycore.properties.template 
     
   - Öffne anschließend die Datei `mycore.properties` und trage alle erforderlichen Werte ein.

   > ⚠️ **Wichtiger Hinweis:**  
   > Die Datei `mycore.properties.template` ist **nicht sofort einsatzbereit**.  
   > Einige Properties sind **absichtlich leer gelassen** — du **musst** sie selbst ausfüllen, bevor das Repository produktiv genutzt werden kann.


