# Kétszemélyes táblajáték
## Programozási környezetek

Az alábbi linken található feladatok közül a 2.19-es feladat , itt megtalálható a feladat leírása
https://arato.inf.unideb.hu/jeszenszky.peter/download/mestint/jatekok.pdf


 `mvn clean package` parancs után futtatható a program a ../prog-env-board-game/target-en belűl  `java -jar boardgame-1.0-shaded.jar` parancsal.
 
 Felváltva lehet játszani két játékosnak. Az első játékos a kék színű korongokkal lesz a második játékos pedig a piros színűekkel. A  `console`-ra folyamatosan kiíratódik a játék állása. Körönkénti bemenet a lépéshez a következő: Megkell adnia a játékosnak hogy melyik korongot hova szeretné rakni azaz két sor,oszlop párost kell megadnia `-` karakterrel elválasztva.
 Egy példa bemenet `(4,1-3,1)` ekkor amennyiben a szabályoknak megfelelő lépésről van szó a negyedik sorban , első oszlopban lévő korongot áthelyezzük a harmadik sor, első oszlopába.
 
 Az utasítás módjáról a programban is leírást kap.
