package se.kau.isgc08.lab4.model;


import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;




public class Line extends DrawingShape {
	//private HelpRect helpRect;
	public void draw(Graphics g) {
		di.drawLine(this, g);
		//di.drawRect(helpRect, g);
	}
	
	public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int width, Color color) {
		super(di);
		setX1(x1);
		setWidth(x2);
		setY1(y1);
		setHeight(y2);
		setLineWidth(width);
		setLineColor(color);
		setAreaColor(Color.BLACK);
		setType("Line");
		//setHelpRect(this.helpRect = new HelpRect(di,y1,x1,width,y2));
	}


}
