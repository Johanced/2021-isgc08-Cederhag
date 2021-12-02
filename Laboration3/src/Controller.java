import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private view view;
	private Model model;
	
	public Controller(int choice) {
		this.model = new Model();
		ViewFactory VF = new ViewFactory();
		view = VF.createView(choice, this);		
		view.initGUI();
	}

	public void handleEvent(String btnClicked) {
		//System.out.println("controller : "+btnClicked);
		
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
			// Vanligt fl�de 'new'
			System.out.println("controller: new : newMainFlow()");
			newMainFlow();
			break;
			
		case "save":
				saveMainFlow();	
			break;
			
		case "saveas":
				ArrayList<String> fileHolder = view.saveFileDialog();
				if(fileHolder != null) {
					System.out.println("save : file != null");
					model.getCurrfile().setFilePath(fileHolder.get(0));
					model.getCurrfile().setFileName(fileHolder.get(1));
					model.getCurrfile().setFileContent(fileHolder.get(2));
					model.saveFile();
				}
			break;
		
		case "open": 
			int code2 = model.modelErrorChecker("checkChanged");
			if(code2 == 2) {
				int choice = view.promptSaveChecker();
				// Save
				if(choice == 0) {
					// VANLIGT FL�DE SAVE!!!
					saveMainFlow();
				}
				//Cancel
				else if (choice == 2 || choice == -1) {
					System.out.println("Controller: open : Aborting 'open'");
					break;
				}
			}
			// VANLIGT FL�DE OPEN
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
			//System.out.println("controller: docChanged");
			model.getCurrfile().setHasChanged(true);
		break;
		}
	}
	// No errors 'open' flow!
	public void openMainFlow() {
		ArrayList<String> file2 = view.openFileDialog();
		if(file2 != null) {
			view.updateTextArea(model.openFile(file2));
			model.getCurrfile().setHasChanged(false);
		}	
	}
	// No errors 'save' Flow!
	public boolean saveMainFlow() {
		if(model.getCurrfile().getFilePath() == null) {
			// File has no path
			ArrayList<String> fileHolder = view.saveFileDialog();
			if(fileHolder != null) {
				System.out.println("controller: save : file != null");
				model.getCurrfile().setFilePath(fileHolder.get(0));
				model.getCurrfile().setFileName(fileHolder.get(1));
				model.getCurrfile().setFileContent(fileHolder.get(2));
				model.saveFile();
				return true;
			}else {
				return false;
			}
		}
		else {
			// File has path
			model.getCurrfile().setFileContent(view.getTextContent());
			model.saveFile();
			//model.saveFile(model.getCurrfile().setFileContent(view.getTextContent()));
			return true;
		}
	}
	// No errors 'new' Flow
	public void newMainFlow() {
		
		view.updateTextArea(model.createNewFile());
		model.getCurrfile().setHasChanged(false);
		view.newFileDialog();
	}
	
	public static void main(String[] args) {
		int choice = 0;
		while(choice != 9) {
			
			System.out.println("---Select View---");
			System.out.println("1: GUI");
			System.out.println("2: CLI");
			System.out.println("9: Quit");
			
			Scanner sc = new Scanner(System.in);
			try {
				choice = sc.nextInt();
				sc.nextLine();
				if(choice == 1 || choice == 2) {
					System.out.println("Starting...");
					new Controller(choice);
					break;
				}
			}catch(java.util.InputMismatchException e) {
				System.out.println("Try again!..");
				System.out.println("ex: "+e);
			}

			

		}		

	}

}
