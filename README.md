# Snake


> [!NOTE]
> If you need help with the installation, the instructions are below.


## English
```
Click on the "Releases" tab (to the right or at the top of the menu in my GitHub repository).
Or directly: https://github.com/GDayIT/Snake/releases

You can find the .exe there as a download link under "Assets".

1. Download .exeClick on the .exe file under "Assets"
   The download will start automatically.

2. RunDouble-click on the .exe
   If Windows shows a warning ("Unknown Publisher"), you can click on "More Info" → "Run Anyway".

If you want to make changes to the project, just download the contents and modify them.



Then in Bash:

javac App.java
echo"App-Class: App" > manifest.txt
jar cfm MyProgram.jar manifest.txt Main.class (MyProgram.jar can be named anything!)
javac -jar MyProgram.jar


Then make it executable:

chmod +x build.sh
./build.sh
```


## German
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
> 💡 **Unter `//Körper "bewegen"`:**
> 
> Ersetze den `else`-Block durch eine Schleife, die sicherstellt, dass das neue Food **nicht auf dem Körper** der Schlange erscheint:
> 
> ```java
> } else {
>     boolean validPosition = false;
>     int zufallX = 0;
>     int zufallY = 0;
> 
>     while (!validPosition) {
>         zufallX = new Random().nextInt(420 / 20) * 20;
>         zufallY = new Random().nextInt(420 / 20) * 20;
>         validPosition = true;
> 
>         for (Rectangle sbod : body) {
>             if (sbod.getLayoutX() == zufallX && sbod.getLayoutY() == zufallY) {
>                 validPosition = false;
>                 break;
>             }
>         }
>     }
> 
>     food.setLayoutX(zufallX);
>     food.setLayoutY(zufallY);
> }
> 
> 
> 💡 **Unter `//Außerhalb des Spielfelds`:**
> 
> Passe die Spielfeldgrenzen an, damit die Schlange **genug Platz zum Wachsen** und **Futter** hat:
> 
> ```java
> if (x < 0 || y < 0 || x >= 420 || y >= 420) {
>     gameover();
>     return;
> }
> ```
