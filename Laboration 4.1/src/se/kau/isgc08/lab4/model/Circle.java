package se.kau.isgc08.lab4.model;


import java.awt.Color;
import java.awt.Graphics;

import ChainOfR.shapeSettings;
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
	
	@Override
	public DrawingShape getLeafMatchingCoords(int x1, int y1) {
		int checker= 0;
		
		if(x1 >= this.x1 && x1 <= width + this.x1) {
			checker++;
		}
		if(y1 >= this.y1 && y1 <= height + this.y1) {
			checker++;
		}
		if(checker == 2) {
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
	
}
