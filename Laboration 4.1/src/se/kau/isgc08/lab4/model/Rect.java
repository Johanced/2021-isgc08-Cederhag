package se.kau.isgc08.lab4.model;

import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;




public class Rect extends DrawingShape {

	private String type = "Rect";
	//private HelpRect helpRect;
	public void draw(Graphics g) {
		di.drawRect(this, g);
		//di.drawRect(helpRect, g);
	}
	
	public Rect(DrawingUtilInterface di, int x1, int y1, int w, int h, int width, Color lineColor, Color area) {
		super(di);
		setX1(x1);
		setWidth(w);
		setY1(y1);
		setHeight(h);
		setLineWidth(width);
		setLineColor(lineColor);
		setAreaColor(area);
		setType("Rect");
		//setHelpRect(this.helpRect = new HelpRect(di, x1, y1, w, h));
	}

}
