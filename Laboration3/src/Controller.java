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
		System.out.println("controller : "+btnClicked);
		
		switch(btnClicked) {
		
			case "new":
				int code = model.modelErrorChecker("checkChanged");
				System.out.println("controller code = "+code);
				if(code == 2) {
					System.out.println("Prompting customdialog!");
					int choice = view.promptSaveChecker();
					// Save
					if(choice == 0) {
						if(model.getCurrfile().getFilePath() == null) {
							customFile file = view.saveFileDialog();
							if(file != null) {
								System.out.println("save : file != null");
								model.saveFile(file);
								model.setCurrfile(file);
							}
						}else {
							customFile file = model.getCurrfile();
						 	file.setFileContent(view.getTextContent());
							model.saveFile(file);
						}
					}
					// Don't save
					else if (choice == 1) {
						view.updateTextArea(model.createNewFile());
					}
				}else {		
					view.updateTextArea(model.createNewFile());
				}
				break;
				
			case "save":
					int code1 = model.modelErrorChecker("save");
					System.out.println("save code = "+code1);
					System.out.println("getcurrfilepath = "+model.getCurrfile().getFilePath());
					// Missing file path
					if(code1 == 1) {	
						this.handleEvent("saveas");
					// Has file path	
					}else {
						customFile file = model.getCurrfile();
					 	file.setFileContent(view.getTextContent());
						model.saveFile(file);
					}	
				break;
				
			case "saveas":
					customFile file = view.saveFileDialog();
					if(file != null) {
						System.out.println("save : file != null");
						model.saveFile(file);
						model.setCurrfile(file);
					}
				break;
			
			case "open": 
				int code2 = model.modelErrorChecker("checkChanged");
				if(code2 == 2) {
					System.out.println("Prompting customdialog!");
					int choice = view.promptSaveChecker();
					// Save
					if(choice == 0) {
						if(model.getCurrfile().getFilePath() == null) {
							customFile file1 = view.saveFileDialog();
							if(file1 != null) {
								System.out.println("save : file != null");
								model.saveFile(file1);
								model.setCurrfile(file1);
							}
						}
						else {
							customFile file1 = model.getCurrfile();
						 	file1.setFileContent(view.getTextContent());
							model.saveFile(file1);
						}
					}
					// Don't save
					else if (choice == 1) {
						customFile file2 = view.openFileDialog();
						if(file2 != null) {
							view.updateTextArea(model.openFile(file2));
							model.getCurrfile().setHasChanged(false);
							model.setCurrfile(file2);
						}	
					}
				}else {
					customFile file2 = view.openFileDialog();
					if(file2 != null) {
						view.updateTextArea(model.openFile(file2));
						model.getCurrfile().setHasChanged(false);
						model.setCurrfile(file2);
					}	
				}
				break;
			
			case "quit":
				int code3 = model.modelErrorChecker("checkChanged");
				if(code3 == 2) {
					int choice = view.promptSaveChecker();		
					if(choice == 0) {
						if(model.getCurrfile().getFilePath() == null) {
							customFile file1 = view.saveFileDialog();
							System.out.println("save: controller: filepath= "+file1.getFilePath());
							model.saveFile(file1);
						}
						else {
							customFile file1 = model.getCurrfile();
						 	file1.setFileContent(view.getTextContent());
							model.saveFile(file1);
						}
					}
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
				file = model.getCurrfile();
				file.setHasChanged(true);
				break;
		}
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
				System.out.println("view: Choice = "+choice);
				if(choice == 1 || choice == 2) {
					System.out.println("STARTING...");
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
