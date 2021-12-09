package se.kau.isgc08.lab4.model;


import java.awt.Color;
import java.awt.Graphics;

import ChainOfR.shapeSettings;
import se.kau.isgc08.lab4.view.DrawingUtilInterface;




public class Line extends DrawingShape {
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
		
		if(x1 >= this.x1 - lineWidth/2 && y1  <= this.y1 + lineWidth/2) {
			System.out.println("x1y1 in");
			int x11 = this.x1 - lineWidth;
			int y11 = this.y1 + lineWidth;
			
			System.out.println("leftB: "+x11+" rightB: "+y11);
			return this;
		}
		if(x1  >= width - lineWidth/2 && y1  <= height + lineWidth/2) {
			System.out.println("hw in");
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
			if(lineWidth > minimumScale) {
				this.lineWidth -= amount;
			}
			
		}

	}
	


}
