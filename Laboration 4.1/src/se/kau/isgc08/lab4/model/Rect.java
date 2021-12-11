package se.kau.isgc08.lab4.model;

import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;




public class Rect extends DrawingShape {

	private String type = "Rect";
	public void draw(Graphics g) {
		di.drawRect(this, g);
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
	}
	@Override
	public DrawingShape getLeafMatchingCoords(int x1, int y1) {
		int checker= 0;
		
		if(x1 >= this.x1 - lineWidth/2  && x1  <= this.x1 + width  + lineWidth/2) {
			checker++;
		}
		if(y1  >= this.y1 - lineWidth/2 && y1  <= this.y1 + height + lineWidth/2) {
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
	public void move(int x1, int y1) {
		this.setX1(x1);
		this.setY1(y1);
	}

}
