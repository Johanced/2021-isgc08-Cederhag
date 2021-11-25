import java.util.Scanner;

import javax.swing.event.DocumentEvent;

public class CLIview extends view {
	private Controller controller;
	private String consoleContent;
	Scanner sc = new Scanner(System.in);
	
	public CLIview(Controller c) {
		this.controller = c;
		System.out.println("CLI VIEW CONSTRUCT");
		//initGUI();
	}
	
	
	public void initGUI() {
		String choice="";
		
		do {
			System.out.println("---Menu---");
			System.out.println("1: New file");
			System.out.println("2: Open file");
			System.out.println("3: Save file");
			//TODO Ska jag lägga till "Edit file" som ett val?
			System.out.println("4: Edit file"); //Kanske implementera? möjligtivs behöver jag icke! Fråga på handledning?
			System.out.println("9: Quit");
            System.out.print("Please enter a number:");
            try {
            	  choice = sc.nextLine();
                  actionPerformed(choice);
			}catch(java.util.InputMismatchException e) {
				System.out.println("CLIview ex: "+e);
			}
          

        } while (choice != "9");

	}
	public customFile openFileDialog() {
		String choice= "";
		while(choice != "9") {
			
			System.out.println("---Open file---");
			System.out.println("Type path to file:");
			System.out.println("9: <-Back");
			
			choice = sc.nextLine();
			
			customFile customfile = new customFile();
			customfile.setFilePath(choice);
			customfile.setFileName(choice);
			//customfile.setFileName(file.getName());
			//System.out.println("view: fileName = "+file.getName());
			System.out.println("CLIview load filepath: "+choice);
			
			return customfile;	
		}
		
		return null;	
	}
	public customFile saveFileDialog() {
		String choice= "";
		while(choice != "9") {
			
			System.out.println("---Save file---");
			System.out.println("Type path to file:");
			System.out.println("9: <-Back");
			
			choice = sc.nextLine();
			System.out.println("CLIview: Save Choice = "+choice);
			
			customFile customfile = new customFile();
			//TODO Lösa file content -> private consoleContent.
			customfile.setFilePath(choice);
			// ** ADD CONTENT TO FILE!! HÄÄÄÄÄRRR
			customfile.setFileContent(choice);
			//customfile.setFileName(file.getName());
			//System.out.println("view: fileName = "+file.getName());
			System.out.println("CLIview filepath: "+choice);
			
			return customfile;	
		}
		
		return null;	
	}
	public int promptSaveChecker() {
		//0 = save
		//1 = don't save
		//2 = cancel
		
		int choice=0;
		do {
			System.out.println("---Changes may go lost on ye!---");
			System.out.println("1. save");
			System.out.println("2. don't save");
			System.out.println("3. cancel");
			try {
				choice = sc.nextInt();
				choice = choice -1;
				System.out.println("prompt returning: "+choice);
				return choice;
			}catch(Exception e) {
				System.out.println("ex: "+e);
			}

		}while(choice != 3);
		return 2;	
	}
	public void updateTextArea(customFile file) {
		if(file != null) {
			System.out.println(file.getFileName()+":: "+file.getFileContent());
		}else {
			System.out.println("updateTextArea: incoming File is null");
			System.out.println("File doesn't exist!");
		}
		
			
	}
	public String getTextContent() {
		//TODO Temporär lösning -> consoleContent kommer vara tom
		return consoleContent;
	}
	public void actionPerformed(String userChoice) {
		System.out.println("CLIview: actionPerformed("+userChoice+");");
		switch(userChoice) {
			case "1": controller.handleEvent("new");
			break;
			case "2": controller.handleEvent("open");
			break;
			case "3": controller.handleEvent("save");
			break;
			case "9": controller.handleEvent("quit");
			break;
		}
	}

	public void insertUpdate(DocumentEvent e) {
		//controller.handleEvent("docChanged");
		//System.out.println("view: insertUpdate: Triggered");
		
	}


	public void removeUpdate(DocumentEvent e) {
		//controller.handleEvent("docChanged");
		//System.out.println("view: removeUpdate: Triggered");
		
	}

	public void changedUpdate(DocumentEvent e) {
		//controller.handleEvent("docChanged");
		//System.out.println("view: changedUpdate: Triggered");
		
	}

}
