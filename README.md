# Kvikmyndahús - HBV201G Verkefni 4

Kvikmyndahúskerfi þar sem notandi getur skoðað kvikmyndir, pantað miða og bætt við nýjum kvikmyndum.

## Höfundur
Viktor Blær Hafþórsson – hafthorsson14@gmail.com

## Uppbygging verkefnis

```
is.vidmot
├── KvikmyndahusApp.java        - Aðalklasi, ræsir forritið
├── controller/
│   ├── AdalController.java     - Controller fyrir aðalviðmótið
│   ├── FerdController.java     - Controller fyrir skoðunarglugga
│   ├── PantunDialogController.java   - Dialog til að panta miða
│   ├── EydaDialogController.java     - Staðfestingardialog við eyðingu
│   └── NyKvikmyndDialogController.java - Dialog til að bæta við kvikmynd
├── switcher/
│   ├── View.java               - Interface (gefið)
│   └── ViewSwitcher.java       - Sér um skipti á milli viðmótsstrjáa
is.vinnlsa
├── Kvikmynd.java               - Gagnaklasar
└── Pantun.java
```

## Hvernig á að byggja með Maven

Krefst Java 17 og Maven.

```bash
mvn clean compile
```

## Hvernig á að keyra

```bash
mvn javafx:run
```

Eða í IntelliJ: Hægri smellur á `KvikmyndahusApp.java` → Run.

## Virkni forritsins

- **Aðalgluggi**: Sýnir lista yfir kvikmyndir með titli, ári og einkunn
- **Skoða kvikmynd**: Veldu kvikmynd og smelltu á "Skoða" til að sjá nánar
- **Panta miða**: Í skoðunarglugga er hægt að panta miða með dagsetning og fjölda
- **Bæta við**: Bæta við nýrri kvikmynd í gegnum dialog
- **Eyða**: Eyða valdri kvikmynd með staðfestingardialog
