# Snake


> [!NOTE]
> If you need help with the installation, the instructions are below.

```
Klicke auf den Reiter "Releases" (rechts oder oben im Menü in meiner GitHub Repository.)

Oder direkt: https://github.com/GDayIT/Snake/releases

Die .exe findest du dort als Download-Link unter „Assets“.

   1. .exe herunterladen
        Klicke auf die .exe-Datei unter „Assets“
        Der Download startet automatisch

   2. Ausführen
      Doppelklick auf die .exe

Falls Windows eine Warnung zeigt („Unbekannter Herausgeber“), kannst du auf „Weitere Informationen“ → „Trotzdem ausführen“.

Falls du änderungen am projekt ausführen willst einfach die inhalte dowloaden.. ändern.

In Bash dann:

  javac App.java
  echo "App-Class: App" > manifest.txt
  jar cfm MeinProgramm.jar manifest.txt Main.class   (MeinProgramm.jar x beliebige bennenung!)
  java -jar MeinProgramm.jar


Dann ausführbar machen:

  chmod +x build.sh
  ./build.sh


```





> [!TIP]
> Just play..


> [!WARNING]
> It can be addicting to optimize and play


> [!CAUTION]
>
>Unter : //Körper "bewegen"
>} else {
>			int zufallX = new Random().nextInt(420 / 20) * 20;
>			int zufallY = new Random().nextInt(420 / 20) * 20;
>			food.setLayoutX(zufallX);
>			food.setLayoutY(zufallY);
>		}
>
>unter: //Ausßerhalb des Spielfelds
>if (x < 0 || y < 0 || x > 420 || y > 420) {
>
>ändern damit die schlange auch genug zu fressen hat.
