import java.awt.*;  
import java.awt.event.*;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.view.DrawingPanel;

public class MouseEventHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	private DrawingShape selShape;
	private View view;
	private Point offset;
	private Point lineX2Y2Offset;
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
				int newX1 = e.getPoint().x - offset.x;
				int newY1 = e.getPoint().y - offset.y;
				int newX2 = e.getPoint().x - lineX2Y2Offset.x;
				int newY2 = e.getPoint().y - lineX2Y2Offset.y;
				selShape.move(newX1,newY1,newX2,newY2, selShape.getPointType());
				view.repaint();
			}	
		}	
	}

	public int getScrollDirection() {
		return scrollDirection;
	}

	public int getScrollAmount() {
		return scrollAmount;
	}

}
