
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
		// TestCase
		case "1": System.out.println("c: TestCase 1"); v.drawResult(m.createHeadContainer());
			break;
		// Save
		case "2": 	System.out.println("c: Save 2"); 
					m.writeObjectToFile();
					
			break;
		// Open
		case "3": System.out.println("c: Open 3"); v.drawResult(m.readObjectFromFile());
			break;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting...");
		new Controller();
		

	}
}
