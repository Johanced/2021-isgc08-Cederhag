# **Laboration 1**

**Av: Johan Cederhag**

**Kravspecifikation och beskrivning av projekt**

Min design ska beskriva och konceptualisera en enkel textredigerare, likt 'notepad'. Användaren kan skriva och redigera text i programmet för att sedan spara texten till fil. Användaren kan välja att öppna en redan befintlig fil eller skapa en ny tom fil.

**Exempel på layout:**

![uiExample](./UML/design/uiExample.PNG)

Filhantering ska göra det möjligt att lagra data så att den kvarstår. Användaren ska kunna göra följande operationer:

* Skapa ny fil
* Öppna befintlig fil
* Spara den nuvarande öppna filen 
* Spara den nuvarande fil genom att välja vart den ska sparas
* Redigera text, denna innehåller mindre operationer såsom:
  * Kopiera text, Klipp ut text, Klistra in text

# Design krav

* Utvecklas i Java (eclipse)
* Swing java bibliotek för GUI
* Arkitekturen ska följa designmönstret MVC
* Filhantering
* Minimal kommunikation mellan MVC klasserna



**ATT GÖRA**

**View**

* getFileContent() : file
* notifyDataChanged(file) /// TVEK PÅ ANVÄNDING
* updateTextArea(file)
* openFileDialog()
* saveFileDialog()
* initGUI()

**Controller**

* ActionPerformed()

**Model**

* createNewFile() : file

* openFile() : file

* saveFile(file) : void

  

**KLART**

* Save as diagram
* open file diagram



# Resultat från Analys

### Use case diagram (Analys)

![usecase1](./UML/design/usecase1.png)

## Sekvensdiagram (Analys)

### new file sekvens (Analys)

![usecase1](./UML/analys/newFileAnalys.drawio.png)

### save file sekvens (Analys)

![usecase1](./UML/analys/saveFileAnalys.drawio.png)

### save as file sekvens (Analys)

![usecase1](./UML/analys/saveAsFileAnalys.drawio.png)

### open file sekvens (Analys)

![usecase1](./UML/analys/openFileAnalys.drawio.png)

### edit text sekvens (Analys)

![usecase1](./UML/analys/editTextAnalys.drawio.png)


# Resultat från Design

## Sekvensdiagram (Design)
### new file sekvens (Design)

![newFile.drawio](./UML/design/newFile.drawio.png)

### open file sekvens(Design)

![openfile.drawio](./UML/design/openfile.drawio.png)

### save as File sekvens (Design)

![saveAsFile.drawio](./UML/design/saveAsFile.drawio.png)

### save file sekvens (Original alt) (Design)

![saveFile(originalalt).drawio](./UML/design/saveFile(originalalt).drawio.png)

### save file sekvens(Alt 1) (Design)

![saveFile(alt1).drawio](./UML/design/saveFile(Alt1).drawio.png)

## Klassdiagram (design)

![classDiagram.drawio](./UML/design/classDiagram.drawio.png)

5
