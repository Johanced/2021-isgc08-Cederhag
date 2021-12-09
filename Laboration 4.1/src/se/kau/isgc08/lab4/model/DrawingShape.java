package se.kau.isgc08.lab4.model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Enumeration;

import javax.swing.JComponent;

import ChainOfR.shapeSettings;
import se.kau.isgc08.lab4.view.DrawingUtilInterface;



// TODO: Auto-generated Javadoc
/**
 * The Class DrawingShape.You need to use this class as a superclass for all you're
 * shapes. The DrawingAPI (which is placed in the View package) relies on DrawingShape as input to drawing the different shapes on screen.
 */
public class DrawingShape implements DrawingComposite {
	
	/** The di. */
	DrawingUtilInterface di;
	// HelpRectangle
	//HelpRect helpRect;
	// Type
	String type;

	/** The width. */
	int width;
	
	/** The x1. */
	int x1;
	
	/** The y1. */
	int y1;
	
	/** The height. */
	int height;
	
	/** The lineWidth. */
	int lineWidth;
	
	/** The line color. */
	Color lineColor;
	
	/** The area color. */
	Color areaColor;
	
	/**
	 * Instantiates a new drawing shape.
	 *
	 * @param di the di
	 */
	public DrawingShape(DrawingUtilInterface di) {
		this.di=di;
	}
	

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#setDrawingAPI(se.kau.isgc08.lab4.view.DrawingUtilInterface)
	 */
	public void setDrawingAPI (DrawingUtilInterface di) {
		this.di=di;
	}
	
	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getX1()
	 */
	public int getX1() {
		return x1;
	}

	/**
	 * Sets the x1.
	 *
	 * @param x1 the new x1
	 */
	public void setX1(int x1) {
		this.x1 = x1;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getWidth()
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width.
	 *
	 * @param w the new width
	 */
	public void setWidth(int w) {
		this.width = w;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getY1()
	 */
	public int getY1() {
		return y1;
	}

	/**
	 * Sets the y1.
	 *
	 * @param y1 the new y1
	 */
	public void setY1(int y1) {
		this.y1 = y1;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Sets the line width.
	 *
	 * @param w the new line width needs to be an even number to make shapefills right.
	 */
	public void setLineWidth(int w) {
		lineWidth=w;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getLineWidth()
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	/**
	 * Sets the line color.
	 *
	 * @param c the new line color
	 */
	public void setLineColor(Color c) {
		lineColor=c;
	}

	/**
	 * Sets the area color.
	 *
	 * @param c the new area color
	 */
	public void setAreaColor(Color c) {
		areaColor=c;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getLineColor()
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#getAreaColor()
	 */
	public Color getAreaColor() {
		return areaColor;
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#add(se.kau.isgc08.lab4.model.DrawingComposite)
	 */
	public void add(DrawingComposite d) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#remove(se.kau.isgc08.lab4.model.DrawingComposite)
	 */
	public void remove(DrawingComposite d) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see se.kau.isgc08.lab4.model.DrawingComposite#draw(java.awt.Graphics)
	 */
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}


	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	/*public HelpRect getHelpRect() {
		return helpRect;
	}

	public void setHelpRect(HelpRect helpRect) {
		this.helpRect = helpRect;
	}
	*/
	/*public void enableHelpRect(Boolean enable) {
		if(enable == true) {
			helpRect.setLineColor(new Color(0.2f,0f,0f,1f));
		}
		if(enable == false) {
			helpRect.setLineColor(new Color(0f,0f,0f,0f));
		}
	}
	*/
	// TA BORT
	/*public boolean contains(int x, int y) {
		int temp = 0;
		if(x >= x1 && x <= width + x1) {
			temp++;
		}
		if(y >= y1 && y <= height + y1) {
			temp++;
		}
		if(temp == 2) {
			return true;
		}
		return false;
	}
	*/
	
	public void scale(int direction, int amount) {
		// Down
		if(direction == 1) {
			width+=amount;
			height+=amount;
			x1 -= amount/2;
			y1 -= amount/2;
		}
		// Up
		if(direction == -1) {
			width-=amount;
			height-=amount;
			x1 += amount/2;
			y1 += amount/2;
		}
	}


	@Override
	public DrawingShape getLeafMatchingCoords(int x1, int y1) {
		// Do nothing
		return null;
	}

	public void delegateSettingToLeaf(shapeSettings setting) {
			// do nothing here
	}





	
}