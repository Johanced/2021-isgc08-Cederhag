import javax.swing.JFrame;

public class GUIFactory {
	
	public GUI createGUI(int choice, Controller c) {
		
		GUI g = null;
		
		if(choice == 1) {
			System.out.println("viewFactory: Returning GUIstandard");
			return new GUIstandard(c);			
		}

		return g;
	}

}
