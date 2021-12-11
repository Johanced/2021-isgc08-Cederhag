package se.kau.isgc08.lab4.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Vector;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;


// TODO: Auto-generated Javadoc
/**
 * The Class DrawingContainer. This class can be used as the Container for your Drawings. 
 * However this is a convenience class provided for your leisure. You can build you're own
 * much better version. Just remember to implement DrawingComposite. 
 */
public class DrawingContainer implements DrawingComposite, Cloneable {
	
	/** The v This attribute will keep the leaf for this container. */
	private Vector<DrawingComposite> v;
	
	
	
	/**
	 * Instantiates a new drawing container. It also instantiates the Vector used for the members the container holds.
	 */
	public DrawingContainer() {
		v=new Vector<DrawingComposite>();
	}
	
	public Vector<DrawingComposite> getVector(){
		return v;
	}
	
	/**
	 * Iterates over all members calling their respective draw methods. This structure can easily be duplicated for creating
	 * other chains. Like identifying a component at at specific location.
	 *
	 * @param g the Graphics object holding screen estate.
	 */
			
	public void draw(Graphics g) {
		DrawingComposite t;
		Enumeration<DrawingComposite> e=v.elements();
		while(e.hasMoreElements()) {
			t= e.nextElement();
			t.draw(g);
		}
	}
	
	/* (non-Javadoc)
	 * @see se.kau.lab4.model.DrawingComposite#add(se.kau.lab4.model.DrawingComposite)
	 */
	public void add(DrawingComposite s) {
		v.add(s);
	}
	
	/* (non-Javadoc)
	 * @see se.kau.lab4.model.DrawingComposite#remove(se.kau.lab4.model.DrawingComposite)
	 */
	public void remove(DrawingComposite s) {
		v.remove(s);
	}
	
	/**
	 * Gets the container. Will return a reference to a Container, will only return Containers on other members null
	 *
	 * @return the container
	 */
	public DrawingComposite getContainer() {
		return this;
	}
	
	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the x1
	 */
	public int getX1() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the width
	 */
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the y1
	 */
	public int getY1() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the height
	 */
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the line width
	 */
	public int getLineWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the line color
	 */
	public Color getLineColor() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Should not be implemented in any specific way for a container.
	 *
	 * @return the area color
	 */
	public Color getAreaColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#setDrawingAPI(se.kau.isgc08.lab4.view.DrawingUtilInterface)
	 */

	public void setDrawingAPI(DrawingUtilInterface di) {
		DrawingComposite t;
		Enumeration<DrawingComposite> e=v.elements();
		while(e.hasMoreElements()) {
			t= e.nextElement();
			t.setDrawingAPI(di);
		}
		// TODO Auto-generated method stub	
	}
	

	@Override
	public DrawingShape getLeafMatchingCoords(int x1, int y1) {
		DrawingComposite temp;
		Enumeration<DrawingComposite> e=v.elements();
		while(e.hasMoreElements()) {
			temp = e.nextElement();
			DrawingShape slask = temp.getLeafMatchingCoords(x1, y1);
			if(slask != null) {
				return slask;
			}
		}
		return null;
	}
	
	public void delegateSettingToLeaf(shapeSettings setting) {
		DrawingComposite temp;
		Enumeration<DrawingComposite> e=v.elements();
		
		while(e.hasMoreElements()) {
			temp = e.nextElement();
			temp.delegateSettingToLeaf(setting);

			
		}
	}

	@Override
	public void move(int x1, int y1, int x2, int y2, String type) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}
	
}
