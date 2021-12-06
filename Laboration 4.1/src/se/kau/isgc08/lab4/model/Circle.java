package se.kau.isgc08.lab4.model;


import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;



public class Circle extends DrawingShape {
	
	//private HelpRect helpRect;
	private String type = "Circle";
	
	public void draw(Graphics g) {
		di.drawCircle(this,g);
		//di.drawRect(helpRect, g);
	}

	
	public Circle(DrawingUtilInterface di,int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		super(di);
		setX1(x1);
		setWidth(w);
		setY1(y1);
		setHeight(h);
		setLineWidth(width);
		setLineColor(lineColor);
		setAreaColor(area);
		setType("Circle");
		//setHelpRect(this.helpRect = new HelpRect(di, x1, y1, w, h));
		}

}
