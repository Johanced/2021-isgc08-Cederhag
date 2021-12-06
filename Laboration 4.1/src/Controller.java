import java.awt.Color;

public class Controller {
	private View v;
	private Model m;
	public Controller() {
		this.m = new Model();
		this.v = new View(this);
	}

	public void handleEvent(String event) {
		
			//System.out.println("HandleEvent: "+event);
			
		switch(event) {
		// TestCase
		case "1": System.out.println("c: TestCase 1"); v.drawResult(m.exampleTest());
			break;
		// Save
		case "2": 	System.out.println("c: Save 2");  m.writeObjectToFile();			
			break;
		// Open
		case "3": System.out.println("c: Open 3"); v.drawResult(m.readObjectFromFile());
			break;
		// Create Line
		case "Line": System.out.println("c: Line");
					 m.addLeafToComposite(m.createLine(37,250,50,50,7,Color.RED));
					 v.drawResult(m.getCurrentDC());
			break;
		// Create Rect
		case "Rect": System.out.println("c: Rect"); 
					  m.addLeafToComposite(m.createRect(125,250,50,50,1,Color.RED, Color.BLUE));
					  v.drawResult(m.getCurrentDC());
			break;
		// Create Circle
		case "Circle": System.out.println("c: Circle"); 
						m.addLeafToComposite(m.createCircle(225,250,50,50,4,Color.YELLOW, Color.BLACK));
						v.drawResult(m.getCurrentDC());
			break;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting...");
		new Controller();
		

	}
}
