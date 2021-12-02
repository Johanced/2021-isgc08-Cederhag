import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.event.DocumentEvent;

public class CLIview extends view {
	//private Controller controller;
	private String consoleContent="";
	Scanner sc = new Scanner(System.in);
	
	public CLIview(Controller c) {
		super(c);
	}
	
	public void initGUI() {
		String choice="";
		
		do {
			System.out.println("---Menu---");
			System.out.println("1: New file");
			System.out.println("2: Open file");
			System.out.println("3: Save file");
			System.out.println("4: Save as file");
			System.out.println("5: Print currentfile content");
			System.out.println("9: Quit");
            System.out.print("My menu choice:");
            try {
            	if(sc.hasNextLine()) {
            		 choice = sc.nextLine();
                     actionPerformed(choice);
                    
            	}
            	 
			}catch(java.util.InputMismatchException e) {
				System.out.println("CLIview ex: "+e);
			}
          

        } while (choice != "9");

	}
	public ArrayList<String> openFileDialog() {
		int choice = 0;
		while(choice != 9) {
			
			System.out.println("---Open file---");
			System.out.println("1. Type path to file");
			System.out.println("9. <-Back");
			System.out.println("Enter choice: ");
			
			if(sc.hasNext()) {
				choice = sc.nextInt();
				sc.nextLine();
				if(choice == 1) {
					System.out.println("---Open file---");
					System.out.println("Enter filepath:");
					String path = sc.nextLine();
					 ArrayList<String> fileHolder = new ArrayList<String>();
					 fileHolder.add(path);
					 fileHolder.add(path);
					return fileHolder;	
				}
				else if(choice == 9) {
					System.out.println("view: returning to menu..");
					return null;
				}
				
			}
		}
		return null;
		
	}
	public ArrayList<String> saveFileDialog() {
			int choice = 0;
			while(choice != 9) {
					
				System.out.println("---Save file---");
				System.out.println("1. Type path to file");
				System.out.println("9. <-Back");
				System.out.println("Enter choice: ");

					choice = sc.nextInt();
					sc.nextLine();
						
					if(choice == 1) {
						System.out.println("---Save file---");
						System.out.println("Enter filepath:");
						String path = sc.nextLine();
						ArrayList<String> fileHolder = new ArrayList<String>();
					    fileHolder.add(path);
					    fileHolder.add(path);
					    fileHolder.add(consoleContent);
						System.out.println("CLIview savefiledialog :filepath: "+choice);
									
						return fileHolder;	
						
					}
					else if(choice == 9) {
						System.out.println("view: returning to menu..");
						return null;
					}else {
						return null;
					}	
			}
			return null;
		}


	public void newFileDialog() {
		
		String userInput="";
		
			System.out.println("---New file---");
			System.out.println("Enter file content:");
            try {
            	if(sc.hasNextLine()) {
            		userInput = sc.nextLine();
                	consoleContent = userInput;
            	}	

			}catch(java.util.InputMismatchException e) {
				System.out.println("CLIview ex: "+e);
			}
          
	}
	public int promptSaveChecker() {
		// --Users Choices--
		//0 = save
		//1 = don't save
		//2 = cancel
		int choice=0;
			System.out.println("---Changes may go lost on ye!---");
			System.out.println("1. save");
			System.out.println("2. don't save");
			System.out.println("3. cancel");
			try {
				choice = sc.nextInt();
				sc.nextLine();
				choice = choice -1;
				//System.out.println("prompt returning: "+choice);
				return choice;
			}catch(Exception e) {
				System.out.println("ex: "+e);
			}
			return 2;	
	}
	public void updateTextArea(customFile file) {
		if(file != null) {
			if(file.getFileName() == null) {
				System.out.println("view: file name is null.. Changing name to 'Untitled.txt'");
				file.setFileName("Untitled.txt");
			}
			consoleContent = file.getFileContent();
			System.out.println(file.getFileName()+" : "+file.getFileContent());
		}else {
			System.out.println("View: File doesn't exist..");
		}		
	}
	
	public String getTextContent() {
		return consoleContent;
	}
	public void printConsoleContent() {
		if(consoleContent.isEmpty()) {
			System.out.println("Filetext: File is empty!");
		}else {
			System.out.println("Filetext: "+consoleContent);	
		}
		
	}
	public void actionPerformed(String userChoice) {
		System.out.println("view: Menuchoice=("+userChoice+");");
		switch(userChoice) {
			case "1": controller.handleEvent("new");  controller.handleEvent("docChanged");
			break;
			case "2": controller.handleEvent("open");
			break;
			case "3": controller.handleEvent("save");
			break;
			case "4": controller.handleEvent("saveas");
			break;
			case "5": printConsoleContent();
			break;
			case "9": controller.handleEvent("quit");
			break;
		}
	}


}
