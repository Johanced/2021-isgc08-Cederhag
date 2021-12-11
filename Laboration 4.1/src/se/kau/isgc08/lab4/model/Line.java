package se.kau.isgc08.lab4.model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.geom.Point2D;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;


public class Line extends DrawingShape {

	private int minimumDistance = 8;
	private String type = "Line";
	public void draw(Graphics g) {
		di.drawLine(this, g);

	}
	
	public Line(DrawingUtilInterface di, int x1, int y1, int x2, int y2, int lineWidth, Color color) {
		super(di);
		setX1(x1);
		setWidth(x2);
		setY1(y1);
		setHeight(y2);
		setLineWidth(lineWidth);
		setLineColor(color);
		setAreaColor(Color.BLACK);
		setType("Line");

	}
	
	@Override
	public DrawingShape getLeafMatchingCoords(int x1, int y1) {
			Point mousePoint = new Point(x1, y1);
			Point x1y1 = new Point(this.x1, this.y1);
			Point x2y2 = new Point(this.width, this.height);
		
			double x1y1dist = Point2D.distance(x1y1.x, x1y1.y, mousePoint.x, mousePoint.y);
			//System.out.println("x1y1 distance to mouse: "+x1y1dist);
			double x2y2dist = Point2D.distance(x2y2.x, x2y2.y, mousePoint.x, mousePoint.y);
			//System.out.println("x2y2 distance to mouse: "+x2y2dist);
			
			if(x1y1dist < minimumDistance) {
				System.out.println("x1y1 distance to mouse: "+x1y1dist);
				this.pointType= "x1y1";
				return this;			
			}
			if(x2y2dist < minimumDistance) {
				System.out.println("x2y2 distance to mouse: "+x2y2dist);
				this.pointType= "x2y2";
				return this;			
			}
			
		return null;
	}
	public void delegateSettingToLeaf(shapeSettings setting) {
		if(this.x1 == setting.getX1() && this.y1 == setting.getY1()) {
			this.width = setting.getWidth();
			this.height = setting.getHeight();
			this.lineWidth = setting.getLineWidth();
		}
	}
	public void scale(int direction, int amount) {
		if(direction == 1) {
			this.lineWidth += amount;
		}
		if(direction == -1) {
			this.lineWidth -= amount;
		}
	}
	public void move(int x1, int y1, int x2, int y2, String type) {
		if(type == "x1y1") {
			System.out.println("moving x1y1...line");
			this.setX1(x1);
			this.setY1(y1);
		}
		if(type == "x2y2") {
			System.out.println("moving x2y2...line");
			this.setWidth(x2);
			this.setHeight(y2);
		}
		
	}

}
