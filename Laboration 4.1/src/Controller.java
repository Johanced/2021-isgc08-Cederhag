import java.awt.Color;

public class Controller {
	private View v;
	private Model m;
	public Controller() {
		this.m = new Model();
		this.v = new View(this);
	}

	public void handleEvent(String event) {
		
			System.out.println("HandleEvent: "+event);
			
		switch(event) {
		// EmptyPanel
		case "clearPanel": System.out.println("Clear panel");   
							m.emptyContainer();
							v.drawResult(m.getCurrentDC());
							v.repaintView();
			break;
		// Save
		case "save": System.out.println("c: Save");  
						m.writeObjectToFile();			
			break;
		// Open
		case "open": System.out.println("c: Open"); 
						v.drawResult(m.readObjectFromFile());
			break;
		// Create Line
		case "Line": System.out.println("c: Line");
						m.addLeafToComposite(m.createLine(v.getDrawUtil(),10,100,100,100,10,Color.RED));
						v.drawResult(m.getCurrentDC());
			break;
		// Create Rect
		case "Rect": System.out.println("c: Rect"); 
						m.addLeafToComposite(m.createRect(v.getDrawUtil(),125,250,50,50,10,Color.RED, Color.BLUE));
						v.drawResult(m.getCurrentDC());
			break;
		// Create Circle
		case "Circle": System.out.println("c: Circle"); 
					 	m.addLeafToComposite(m.createCircle(v.getDrawUtil(),225,250,50,50,4,Color.YELLOW, Color.BLACK));
					 	v.drawResult(m.getCurrentDC());
			break;
			
		case "LineColor": 
						m.changeShapeLineColor(m.getLeafAtCoords(v.getSelectedShapeCoords("x"), v.getSelectedShapeCoords("y")), v.showColorPicker());
						v.repaintView();
						
			break;
		case "AreaColor":
						m.changeShapeAreaColor(m.getLeafAtCoords(v.getSelectedShapeCoords("x"), v.getSelectedShapeCoords("y")), v.showColorPicker());
						v.repaintView();
			break;
			
		case "ConfirmChanges": 
						m.startEditChain(v.constructShapeSettings());
						v.repaintView();
			break;
			
		case"getShapeAtCoords":
						v.updateEditPanelSettings(v.getShapeAtCoords(m.getLeafAtCoords(v.getMouseCoords("x"), v.getMouseCoords("y"))));				
			break;
			
		case "scaleShape": // updates EditGUIPanel attributes to the current selected shape!
						v.updateEditPanelSettings(m.scaleShape(v.getShapeAtCoords(m.getLeafAtCoords(v.getSelectedShapeCoords("x"), v.getSelectedShapeCoords("y"))), v.getScrollAmount(), v.getScrollDirection()));
						v.repaintView();
			break;
		case "removeShape": // updates EditGUIPanel attributes to the current selected shape!
							System.out.println("removeShape");
							m.removeLeaf(v.getShapeAtCoords(m.getLeafAtCoords(v.getSelectedShapeCoords("x"), v.getSelectedShapeCoords("y"))));
							v.repaintView();
		break;
		
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting...");
		new Controller();
		

	}
}
