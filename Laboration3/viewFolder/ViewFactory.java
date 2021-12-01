

public class ViewFactory {
	
	public view createView(int choice, Controller c) {
		
		view v = null;
		
		if(choice == 1) {
			System.out.println("viewFactory: Returning GUI");
			return new GUIview(c);			
		}
		if(choice == 2) {
			System.out.println("viewFactory: Returning CLI");
			return new CLIview(c);
		}
		return v;
	}

}
