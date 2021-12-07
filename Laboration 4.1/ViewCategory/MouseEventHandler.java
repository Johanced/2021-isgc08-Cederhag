import java.awt.*;  
import java.awt.event.*;
import java.util.LinkedList;

import se.kau.isgc08.lab4.model.DrawingComposite;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.view.DrawingPanel;

public class MouseEventHandler implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	private LinkedList<DrawingShape> shapeList;
	private DrawingShape selShape;
	private View view;
	private Point offset;
	
	public MouseEventHandler(DrawingPanel DrawPanel, View view) {
		this.view = view;
		DrawPanel.addMouseListener(this);
		DrawPanel.addMouseMotionListener(this); 
		DrawPanel.addMouseWheelListener(this);
		view.addKeyListener(this);
		shapeList = new LinkedList<DrawingShape>();
		
		
	}
	// Adda alla shapes till mouse listener!
	public void addObjectsMouseListenerList(DrawingContainer shapeContainer) {
		
		for (DrawingComposite shape : shapeContainer.getVector()) {
			if(!shapeList.contains(shape)) {
				System.out.println("Added: "+shape.getClass());
				DrawingShape newShape = (DrawingShape) shape;
				shapeList.add(newShape);
			}
		}
	}
	

	// Rätt värdelös med att registrera klick!!
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("X: "+e.getX()+" Y: "+e.getY());
		//System.out.println("comp: "+e.getSource().getClass().getCanonicalName());
		
		}
	
	public void mouseMoved(MouseEvent e) {
		/*for (DrawingShape shape : shapeList) {
			//System.out.println("shapeX : "+shape.getX1()+ " shapeY : "+shape.getY1());
			if(shape.contains(e.getX(), e.getY())) {

			 System.out.println("HIT:name: "+shape.getType());
			 selShape = shape;
			}
		}*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for (DrawingShape shape : shapeList) {
			//System.out.println("shapeX : "+shape.getX1()+ " shapeY : "+shape.getY1());
			if(shape.contains(e.getX(), e.getY())) {

			 System.out.println("HIT:name: "+shape.getType());
			 selShape = shape;
			}
		}
		if(selShape != null) {
			if (selShape.contains(e.getPoint().x, e.getPoint().y)) {
				offset = new Point(e.getPoint().x - selShape.getX1(),e.getPoint().y - selShape.getY1());
				
				//selShape.enableHelpRect(true);
	        }
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		//selShape.enableHelpRect(false);
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
	// Använd för att förstora objekt efter användaren valt!
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		 if (e.getWheelRotation() < 0) {
	          System.out.println("Up... " + e.getWheelRotation());
	          if(selShape != null) {
	        	  selShape.scale(e.getWheelRotation(), e.getScrollAmount());
	        	  view.repaint();
	          }
	          
	        } else {
	          System.out.println("Down... " + e.getWheelRotation());
	          if(selShape != null) {
	        	  selShape.scale(e.getWheelRotation(), e.getScrollAmount());
	        	  view.repaint();
	          }
	        }
	        System.out.println("ScrollAmount: " + e.getScrollAmount());

	        if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
	          System.out.println("MouseWheelEvent.WHEEL_UNIT_SCROLL");
	        }

	        if (e.getScrollType() == MouseWheelEvent.WHEEL_BLOCK_SCROLL) {
	          System.out.println("MouseWheelEvent.WHEEL_BLOCK_SCROLL");
	        }
	      }
	@Override
	public void mouseDragged(MouseEvent e) {
		if(selShape != null) {
			if(offset != null) {
				int newX = e.getPoint().x - offset.x;
				int newY = e.getPoint().y - offset.y;
				System.out.println("mouse dragging...");
				selShape.setX1(newX);
				selShape.setY1(newY);
				//selShape.getHelpRect().setX1(newX);
				//selShape.getHelpRect().setY1(newY);
				view.repaint();
			}
			
		}
	
		
	}
	
	public int getSelectedShapeByIndex() {
		int index = shapeList.indexOf(selShape);
		System.out.println("mouseHandler: Returning index :"+index);
		return index;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key Pressed");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key Pressed");
	}
	@Override
	public void keyReleased(KeyEvent key) {
		// TODO Auto-generated method stub
		System.out.println("key Pressed");
		
		/*System.out.println("KLEY PRESSED");
		if(key.getKeyCode() == KeyEvent.VK_DELETE) {
			System.out.println("DELETE: Pressed");
		}
		*/
		
	}

}
