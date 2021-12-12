import java.awt.*;  
import java.awt.event.*;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.view.DrawingPanel;

public class MouseEventHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	private DrawingShape selShape;
	private View view;
	private Point offset;
	private Point lineX2Y2Offset;
	private int offsetNewX1;
	private int offsetNewY1;
	private int lineOffsetX2;
	private int lineOffsetY2;
	private Point mouseCoords;
	private DrawingPanel DrawPanel;
	private int scrollDirection;
	private int scrollAmount;
	
	public MouseEventHandler(DrawingPanel DrawPanel, View view) {
		this.view = view;
		this.DrawPanel = DrawPanel;
		this.DrawPanel.addMouseListener(this);
		this.DrawPanel.addMouseMotionListener(this); 
		this.DrawPanel.addMouseWheelListener(this);
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		}
	
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		mouseCoords = new Point(e.getX(), e.getY());
		view.triggerGetShapeAtCoords();
		if(selShape != null) {
			offset = new Point(e.getPoint().x - selShape.getX1(),e.getPoint().y - selShape.getY1());
			lineX2Y2Offset = new Point(e.getPoint().x - selShape.getWidth(), e.getPoint().y - selShape.getHeight());
		}	
	}

	public int getMouseX() {
		return mouseCoords.x;
	}
	public int getMouseY() {
		return mouseCoords.y;
	}
	public int getSelectedShapeX() {
		if(selShape != null) {
			return selShape.getX1();
		}
		return -1;
		
	}
	public int getSelectedShapeY() {
		if(selShape != null) {
			return selShape.getY1();
		}
		return -1;
	}
	public void receiveShape(DrawingShape shape) {
		selShape = shape;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		offset = null;
		
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		 if (e.getWheelRotation() < 0) {
	          if(selShape != null) {
	        	  scrollDirection = e.getWheelRotation();
	        	  scrollAmount = e.getScrollAmount();
	        	  view.triggerScaleShape();
	          }
	          
	        } else {
	          if(selShape != null) {
	        	  scrollDirection = e.getWheelRotation();
	        	  scrollAmount = e.getScrollAmount();
	        	  view.triggerScaleShape();
	          }
	        }
	      }
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		if(selShape != null) {
			if(offset != null) {
				offsetNewX1 = e.getPoint().x - offset.x;
				offsetNewY1 = e.getPoint().y - offset.y;
				lineOffsetX2 = e.getPoint().x - lineX2Y2Offset.x;
				lineOffsetY2 = e.getPoint().y - lineX2Y2Offset.y;
				//view.moveThisShape();
				selShape.move(offsetNewX1,offsetNewY1,lineOffsetX2,lineOffsetY2, selShape.getPointType());
				view.repaintView();
			}	
		}	
	}

	public int getScrollDirection() {
		return scrollDirection;
	}

	public int getScrollAmount() {
		return scrollAmount;
	}

	public int getOffsetNewX1() {
		return offsetNewX1;
	}

	public void setOffsetNewX1(int offsetNewX1) {
		this.offsetNewX1 = offsetNewX1;
	}

	public int getOffsetNewY1() {
		return offsetNewY1;
	}

	public void setOffsetNewY1(int offsetNewY1) {
		this.offsetNewY1 = offsetNewY1;
	}

	public int getLineOffsetX2() {
		return lineOffsetX2;
	}

	public void setLineOffsetX2(int lineOffsetX2) {
		this.lineOffsetX2 = lineOffsetX2;
	}

	public int getLineOffsetY2() {
		return lineOffsetY2;
	}

	public void setLineOffsetY2(int lineOffsetY2) {
		this.lineOffsetY2 = lineOffsetY2;
	}
	public String getPointType() {
		return selShape.getPointType();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
