package ChainOfR;
import java.awt.Color;

public class shapeSettings {
	private int x1;
	private int y1;
	private int width;
	private int height;
	private int lineWidth;
	private Color lineColor;
	private Color areaColor;
	
	public shapeSettings(int x1, int y1,int width, int height, int lineWidth) {
		this.setX1(x1);
		this.setY1(y1);
		this.width = width;
		this.height = height;
		this.lineWidth = lineWidth;
		//this.lineColor = lineColor;
		//this.areaColor = areaColor;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getAreaColor() {
		return areaColor;
	}

	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

}
