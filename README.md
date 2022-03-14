# reposis-module-archetype

Ein Template für alle Reposis-Anwendungen als maven-archetype.

## reposis-modul in jar umstellen

### Archtype bauen, damit man ihn lokal einsetzen kann:
* reposis-module-archetype auschecken
* `mvn clean install`

### Maven Projekt erstellen
* reposis-Projekt, welches migriert werden soll, auschecken
  * `mvn archetype:generate`
    * de.gbv.ostasien groupId
    * artifactID reposis_ostasion
    * version 2021.06-SNAPSHOT
  * erstellt reposis_ostasien mit entsprechender Struktur

### Dateien

* Kopieren von save/webpages/ zu src/main/resources/META-INF/resources/
* Kopieren von resources/ zu src/main/resources
* Vorerst löschen von resources/log4j2.xml
* Properties
  * Es muss unterschieden werden in Properties die nur für das Test oder Produktiv-System sind, oder welche die für alle Allg. sind
  * Nur die allg. Properties sollten in dem Modul enthalten sein

### Allgemeines
  * setup-reposis_ostasien.txt - enthält CLI-Befehle z.B. anpassen von Klassifikation die nur für diese Anwendung benötigt werden
  * CI=true mvn clean install  -> baut analog zu Jenkins, benötigt lokal installierten WebDriver
  * einfacher Seleniumtest zum prüfen ob Anwendung noch startet -> wichtig, muss mit IT enden! (z.B. https://github.com/gbv/reposis_digibib/blob/2021.06/src/test/java/de/vzg/reposis/digibib/DigibibLibIT.java)

### Verzeichnissstruktur 

  * src/
    * main/ - Alle Dateien die später im Jar Laden
      * java/ - Enthält Java Code speziell für diese Anwendung
      * resources/  - Resourcen die über den "Classpath" zur verfügung stehen
      * META-INF/resources - Web Resourcen welche im Kontext der Anwedung abrufbar sind
    * test/ - Alle Dateien für das Testen der Anwendung
      * java/ - Enthält Java Code zum Testen der Anwendung  

## Troubleshooting
* mvn clean install -Pauto-update   -> sortiert pom.xml
* CI=true mvn solr-runner:stop      -> stoppt jenkins-Solr im Falle eines Test-Fehlers 
