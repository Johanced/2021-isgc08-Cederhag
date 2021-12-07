import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.model.Rect;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Model {
	//private DrawingUtil da;
	private DrawingContainer currentDC;
	
	public Model() {
		//da=new DrawingUtil();
		currentDC = new DrawingContainer();
	}
	// EXAMPLE
	public DrawingContainer exampleTest(DrawingUtil da) {
		DrawingContainer container = new DrawingContainer();
		Line l=new Line(da,50,3,75,50,1,Color.RED);
		container.add(l);
		currentDC = container;
		
		return container;
	}
	public void addLeafToComposite(DrawingShape shape) {
		currentDC.add(shape);
		System.out.println("shape added: "+shape.getHeight());
	}
	public void removeLeaf(DrawingShape shape) {
		currentDC.remove(shape);
	}
	public void startEditChain() {
		//TODO; Edit shape -> Sker i chain -> color, linecolor, areaColor, width, height, 
	}
	public void writeObjectToFile() {
		try {
			 
            FileOutputStream fileOut = new FileOutputStream("test1.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(currentDC);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	public DrawingContainer readObjectFromFile() {
		FileInputStream fi;
		try {
			fi = new FileInputStream("test1.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			currentDC = (DrawingContainer) oi.readObject();
		} catch (IOException e) {
			System.out.println("Model: readObject : Error, IO error");
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			System.out.println("Model: readObject : Error, Class not found!");
			e.printStackTrace();
		}
		return currentDC;
	}
	
	public Circle createCircle(DrawingUtil DU,int x1, int y1, int x2, int y2, int width, Color color, Color area) {
		
		return new Circle(DU, x1, y1, x2, y2, width, color, area);
	}
	public Line createLine(DrawingUtil DU,int x1, int y1, int x2, int y2, int width, Color color) {
		
		return new Line(DU, x1, y1, x2, y2, width, color);
	}
	public Rect createRect(DrawingUtil DU,int x1, int y1, int x2, int y2, int width, Color color, Color area) {
		
		return new Rect(DU, x1, y1, x2, y2, width, color, area);
	}
	/*public HelpRect createHelpRect(int x1, int y1, int width, int height) {
		
		return new HelpRect(da, x1, y1, width, height);	
	}
	*/
	public void setCurrentDC(DrawingContainer d) {
		currentDC = d;
	}
	public DrawingContainer getCurrentDC() {
		return currentDC;
	}

}
