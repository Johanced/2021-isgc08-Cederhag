# **Laboration 1**

**Av: Johan Cederhag**

**Kravspecifikation och beskrivning av projekt**

Min design ska beskriva och konceptualisera en enkel textredigerare, likt 'notepad'. Användaren kan skriva och redigera text i programmet för att sedan spara texten till fil. Användaren kan välja att öppna en redan befintlig fil eller skapa en ny tom fil.

**Exempel på layout:**

![uiExample](./UML/analys/uiExample.PNG)

Filhantering ska göra det möjligt att lagra data så att den kvarstår. Användaren ska kunna göra följande operationer:

* Skapa ny fil
* Öppna befintlig fil
* Spara den nuvarande öppna filen 
* Spara den nuvarande fil genom att välja vart den ska sparas
* Redigera text, denna innehåller mindre operationer såsom:
  * Kopiera text, Klipp ut text, Klistra in text
* Operationerna ovan ska vara tillgängliga i menyn, via knappen "File"

![uiExample2](./UML/analys/uiExample2.PNG)

# Design krav

* Utvecklas i språket Java (eclipse utvecklingsmiljö)
* Swing java bibliotek för GUI
* Arkitekturen ska följa designmönstret MVC
* Minimal kommunikation mellan MVC klasserna
* Filhantering

# Resultat från Analys

### Use case diagram (Analys)

![usecase1](./UML/analys/usecase1.png)

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

## Klassdiagram (Analys)

![application(analys).drawio](./UML/analys/application(analys).drawio.png)


# Resultat från Design

## Sekvensdiagram (Design)
### new file sekvens (alt 0) (Design)

![newFile(alt0).drawio](./UML/design/newFile(alt0).drawio.png)

### new file sekvens (alt 1) (Design)

![newFile(alt1).drawio](./UML/design/newFile(alt1).drawio.png)

### open file sekvens (Design)

![openfile.drawio](./UML/design/openfile.drawio.png)

### save as File sekvens (Design)

![saveAsFile.drawio](./UML/design/saveAsFile.drawio.png)

### save file sekvens (alt 0) (Design)

![saveFile(alt0).drawio](./UML/design/saveFile(alt0).drawio.png)

### save file sekvens (alt 1) (Design)

![saveFile(alt1).drawio](./UML/design/saveFile(alt1).drawio.png)

## Klassdiagram (design)

### Application  Analys + Design 

![application(analysdesign)drawio](./UML/design/application(analysdesign)drawio.png)

### Application diagram Design MVC

#### **Version 1:**

![classDiagram.drawio](./UML/design/classDiagram.drawio.png)

#### **Version 2:**

![classDiagram.drawio](./UML/design/classDiagram(Updated).drawio.png)

