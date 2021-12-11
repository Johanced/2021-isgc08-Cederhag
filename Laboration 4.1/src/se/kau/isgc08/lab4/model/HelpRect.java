/*
package se.kau.isgc08.lab4.model;

import java.awt.Color;
import java.awt.Graphics;

import se.kau.isgc08.lab4.view.DrawingUtilInterface;

public class HelpRect extends DrawingShape {
	private String pointType;
	private String type = "lineHelpRect";
	private int lineWidth = 2;
	private int width = 10;
	private int height = 10;
	private DrawingShape master;
	

	public void draw(Graphics g) {
		di.drawRect(this, g);
	}
	
	public HelpRect(DrawingUtilInterface di, int x1, int y1, String point) {
		super(di);
		setX1(x1);
		setWidth(width);
		setY1(y1);
		setHeight(height);
		setLineWidth(lineWidth);
		setLineColor(Color.BLACK);
		setAreaColor(new Color(1f, 0f, 0f ,0.5f));
		this.type = "lineHelpRect";
		this.pointType = point;
		//this.master = master;
		

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
	public void setVisible(Boolean choice) {
		if(choice == false) {
			this.setAreaColor(new Color(0f,0f,0f,0f));
		}
		if(choice == true) {
			this.setAreaColor(new Color(1f,0f,0f,0.5f));
		}
	}
	
	public void delegateSettingToLeaf(shapeSettings setting) {
		/*if(this.x1 == setting.getX1() && this.y1 == setting.getY1()) {
			this.width = setting.getWidth();
			this.height = setting.getHeight();
			this.lineWidth = setting.getLineWidth();
		}*/
	/*}/*
	 
	public void scale(int direction, int amount) {
		master.scale(direction, amount);
	}
	public void move(int x1, int y1, String type) {
		System.out.println("master = "+master.getType());
		this.setX1(x1);
		this.setY1(y1);
		master.move(x1, y1, type);
	}
	public void setAreaColor(Color c) {
		if(master != null) {
			master.setAreaColor(c);
		}	
	}
	public void setLineColor(Color c) {
		if(master != null) {
			master.setLineColor(c);
		}	
	}
	/*
	  public void setLineWidth(int width) {
		if(master != null) {
		master.setLineWidth(width);
		}
	}
	*/
	/*public int getLineWidth() {
		return master.getLineWidth();
	}*/
/*

	public String getPointType() {
		return pointType;
	}
	public void setMaster(DrawingShape shape) {
		this.master = shape;
	}
	public DrawingShape getMaster() {
		return master;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}
	public DrawingShape deleteThis() {
		return master;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
*/