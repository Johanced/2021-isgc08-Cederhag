import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import se.kau.isgc08.lab4.model.Circle;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class Model {
	DrawingUtil da=new DrawingUtil();
	DrawingContainer currentDC = new DrawingContainer();
	
	public Model() {
		
	}
	
	public DrawingContainer createHeadContainer() {
		DrawingContainer container = new DrawingContainer();
		Line l=new Line(da,3,3,50,50,1,Color.RED);
		container.add(l);
		currentDC = container;
		
		return container;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return currentDC;
	}
	
	public Circle createCircle() {
		
		return new Circle(da, 0, 0, 0, 0, 3, Color.GREEN, null);
	}
	public void setCurrentDC(DrawingContainer d) {
		currentDC = d;
	}

}
