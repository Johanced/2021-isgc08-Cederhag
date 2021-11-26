public class Controller {
	private view view;
	private Model model;
	
	public Controller() {
		this.view = new view(this);
		this.model = new Model();
	}

	public void handleEvent(String btnClicked) {
		System.out.println("controller : "+btnClicked);
		
		switch(btnClicked) {
		
			case "new":
				int code = model.modelErrorChecker("checkChanged");
				System.out.println("controller code = "+code);
				if(code == 2) {
					int choice = view.promptSaveChecker();
					// Save
					if(choice == 0) {
						boolean isExecuted = saveMainFlow();
						if(isExecuted) {
							newMainFlow();
							break;
						}
					}
					// Cancel
					else if (choice == 2 || choice == -1) {
						System.out.println("Controller : new : Aborting 'new'");
						break;
					}
				}
				// Vanligt flöde 'new'
				newMainFlow();
				break;
				
			case "save":
					saveMainFlow();	
				break;
				
			case "saveas":
					customFile file = view.saveFileDialog();
					if(file != null) {
						System.out.println("save : file != null");
						model.saveFile(file);
						model.setCurrfile(file);
						file.setHasChanged(false);
					}
				break;
			
			case "open": 
				int code2 = model.modelErrorChecker("checkChanged");
				if(code2 == 2) {
					int choice = view.promptSaveChecker();
					// Save
					if(choice == 0) {
						// VANLIGT FLÖDE SAVE!!!
						saveMainFlow();
					}
					//Cancel
					else if (choice == 2 || choice == -1) {
						System.out.println("Controller: open : Aborting 'open'");
						break;
					}
				}
				// VANLIGT FLÖDE OPEN
				openMainFlow();
				break;
			
			case "quit":
				int code3 = model.modelErrorChecker("checkChanged");
				if(code3 == 2) {
					int choice = view.promptSaveChecker();	
					// Save
					if(choice == 0) {
						saveMainFlow();
					}
					// Abort
					else if(choice == 2 || choice == -1) {
						System.out.println("Quit Aborted!");
						break;
					}	
				}
				System.out.println("controller: Quit");
				System.exit(0);
				break;
				
			case "docChanged":
				System.out.println("controller: docChanged");
				model.getCurrfile().setHasChanged(true);
				break;
		}
	}
	// No errors 'open' flow!
	public void openMainFlow() {
		customFile file2 = view.openFileDialog();
		if(file2 != null) {
			view.updateTextArea(model.openFile(file2));
			model.getCurrfile().setHasChanged(false);
			model.setCurrfile(file2);
		}	
	}
	// No errors 'save' Flow!
	public boolean saveMainFlow() {
		if(model.getCurrfile().getFilePath() == null) {
			// File has no path
			customFile file1 = view.saveFileDialog();
			if(file1 != null) {
				System.out.println("save : file != null");
				model.saveFile(file1);
				file1.setHasChanged(false);
				model.setCurrfile(file1);
				return true;
			}else {
				return false;
			}
		}
		else {
			// File has path
			customFile file1 = model.getCurrfile();
		 	file1.setFileContent(view.getTextContent());
			model.saveFile(file1);
			file1.setHasChanged(false);
			model.setCurrfile(file1);
			return true;
		}
	}
	// No errors 'new' Flow
	public void newMainFlow() {
		view.updateTextArea(model.createNewFile());
		model.getCurrfile().setHasChanged(false);
	}
	
	public static void main(String[] args) {
		new Controller();

	}

}
