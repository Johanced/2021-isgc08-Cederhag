import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingComposite;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.model.Rect;
import se.kau.isgc08.lab4.model.shapeSettings;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Model {
	private DrawingContainer currentDC;
	
	public Model() {
		currentDC = new DrawingContainer();
		
	}
	
	public void emptyContainer() {
		currentDC = new DrawingContainer();
	}

	public void addLeafToComposite(DrawingShape shape) {
		currentDC.add(shape);
	}
	public void removeLeaf(DrawingShape shape) {
		if(shape != null) {
		currentDC.remove(shape);
		}
	}
	public boolean startEditChain(shapeSettings setting) {
		if(setting != null) {
		currentDC.delegateSettingToLeaf(setting);
		return true;
		}
		return false;
	}
	public DrawingShape getLeafAtCoords(int x1, int y1) {
		return currentDC.getLeafMatchingCoords(x1, y1);
		
	}
	public void changeShapeLineColor(DrawingShape slaskShape, Color pickedColor) {
		if(slaskShape != null) {
			slaskShape.setLineColor(pickedColor);
		}	
	}
	public void changeShapeAreaColor(DrawingShape slaskShape, Color pickedColor) {
		if(slaskShape != null) {
			slaskShape.setAreaColor(pickedColor);
		}	
	}
	public DrawingShape scaleShape(DrawingShape slaskShape, int amount, int direction) {
		if(slaskShape != null ) {
			slaskShape.scale(direction, amount);
		}
		return slaskShape;
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
			for(DrawingComposite shape : currentDC.getVector()) {
				System.out.println("loaded shape: "+shape.getType());
			}
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

	public void setCurrentDC(DrawingContainer d) {
		currentDC = d;
	}
	public DrawingContainer getCurrentDC() {
		return currentDC;
	}

}
