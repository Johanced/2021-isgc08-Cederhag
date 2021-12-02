

public class ViewFactory implements Factory {
	
	public view createView(int choice, Controller c) {
		
		if(choice == 1) {
			System.out.println("viewFactory: Returning GUI");
			return new GUIview(c);			
		}
		if(choice == 2) {
			System.out.println("viewFactory: Returning CLI");
			return new CLIview(c);
		}
		return null;
	}

}
