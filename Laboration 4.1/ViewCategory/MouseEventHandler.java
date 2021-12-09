import java.awt.*;  
import java.awt.event.*;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.view.DrawingPanel;

public class MouseEventHandler implements MouseListener, MouseMotionListener, MouseWheelListener {
	private DrawingShape selShape;
	private View view;
	private Point offset;
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
		/*view.addKeyListener(new KeyAdapter() {
			 public void keyTyped(KeyEvent e) {
			        System.out.println("keyTyped: '" + e.getKeyChar() + "'");
			      }
		});
		*/
		
	}
	
	// Rätt värdelös med att registrera klick!!
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
		if(selShape != null && selShape.getType() != "Line") {
			if(offset != null) {
				int newX = e.getPoint().x - offset.x;
				int newY = e.getPoint().y - offset.y;
				selShape.setX1(newX);
				selShape.setY1(newY);
				view.repaint();
			}
			
		}
		if(selShape != null && selShape.getType() == "Line") {
			if(offset != null) {
				int newX = e.getPoint().x - offset.x;
				int newY = e.getPoint().y - offset.y;

				Point mouseP = new Point(e.getX(), e.getY());
				
				Point PointX1Y1 = new Point(selShape.getX1(), selShape.getY1());
				Point PointWH = new Point(selShape.getWidth(), selShape.getHeight());

				double whDist = PointWH.distance(mouseP);
				System.out.println("wh = "+whDist);
				double x1y1Dist = PointX1Y1.distance(mouseP);
				System.out.println("x1y1 = "+x1y1Dist);
				
				if(x1y1Dist < whDist) {
					selShape.setX1(e.getX());
					selShape.setY1(e.getY());
				}else if(whDist < x1y1Dist) {	
					selShape.setWidth(e.getX());
					selShape.setHeight(e.getY());
				}
				
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

	/*//TODO; Addera Delete-funktion med Knapp tryck!!
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key Pressed: "+c);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		System.out.println("key Pressed: "+c);
	}
	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		char c = key.getKeyChar();
		System.out.println("key Pressed: "+c);
		
	}
	*/

}
