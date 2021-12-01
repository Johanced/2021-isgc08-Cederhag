
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIview extends view implements GUI {

	//private JFrame mainFrame; // MAINFRAME ÄR NULL FIXXXAAAA
	//private JTextArea textArea;
	private Controller controller;
	private GUI gui;

	public GUIview(Controller c) {
		this.controller = c;
		GUIFactory GUIF = new GUIFactory();
		gui = GUIF.createGUI(1,controller);		
		//gui.initGUI();
		//initGUI();
	}
	
	
	//public void initGUI() {
		
		
		/*
		mainFrame = new JFrame("Notepad - Untitled.txt");
		textArea = new JTextArea(); 
		JMenuBar menuBar = new JMenuBar();
		JMenu menu1 = new JMenu("File");
		
		JMenuItem menuItem1 = new JMenuItem("New");
		JMenuItem menuItem2 = new JMenuItem("Open");
		JMenuItem menuItem3 = new JMenuItem("Save");
		JMenuItem menuItem4 = new JMenuItem("Save as");
		JMenuItem menuItem9 = new JMenuItem("Quit");
		
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);
		menuItem4.addActionListener(this);
		menuItem9.addActionListener(this);
		
		menuItem1.setActionCommand("new");
		menuItem2.setActionCommand("open");
		menuItem3.setActionCommand("save");
		menuItem4.setActionCommand("saveas");
		menuItem9.setActionCommand("quit");
		
		menu1.add(menuItem1);
		menu1.add(menuItem2);
		menu1.add(menuItem3);
		menu1.add(menuItem4);
		menu1.add(menuItem9);
		
		menuBar.add(menu1);
		textArea.getDocument().addDocumentListener(this);
		
		mainFrame.setJMenuBar(menuBar);
		mainFrame.add(textArea);
		mainFrame.setSize(500,650);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		*/
	//}
	public customFile openFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt");
		fileChooser.setFileFilter(filter);
		File file = null;
		int result = fileChooser.showOpenDialog(mainFrame);
		if (result == JFileChooser.APPROVE_OPTION) {
		    file = fileChooser.getSelectedFile();
		    customFile customfile = new customFile();
		    customfile.setFilePath(file.getAbsolutePath());
		    customfile.setFileName(file.getName());
		    System.out.println("View: fileName = "+file.getName());
		    System.out.println("View: openFileDialog: Selected file: " + file.getAbsolutePath());
		    return customfile;
		}
		return null;
	}
	public customFile saveFileDialog() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("txt files", "txt");
		fileChooser.setFileFilter(filter);
		int result = fileChooser.showSaveDialog(mainFrame);
		File fileToSave = null;
		if (result == JFileChooser.APPROVE_OPTION) {
		    fileToSave = fileChooser.getSelectedFile();
		    customFile customfile = new customFile();
		    customfile.setFilePath(fileToSave.getAbsolutePath());
		    customfile.setFileContent(textArea.getText());
		    customfile.setFileName(fileToSave.getName());
		    System.out.println("View: Save as file: " + fileToSave.getAbsolutePath());
		    return customfile;
		}else {
			return null;
		}
				
	}
	
	public int promptSaveChecker() {
		Object[] options = {"Save", "Don't save", "Cancel"};
			int n = JOptionPane.showOptionDialog(mainFrame, "Do you want to save changes?","Ändringar ej sparade",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.WARNING_MESSAGE,
							null,
							options,
							options[2]);
			System.out.println("View: PromptSaveChecker n: "+n);
		return n;	
	}
	
	public void updateTextArea(customFile file) {
		System.out.println("View: updateTextArea: file has name: "+file.getFileName());
		
		if(file.getFileName() == null) {
			System.out.println("View: file name is NULL!");
			file.setFileName("Untitled.txt");
		}
	    mainFrame.setTitle("Notepad - "+file.getFileName());
		textArea.setText(file.getFileContent());
	}
	public String getTextContent() {
		return textArea.getText();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		controller.handleEvent(btnClicked);
		
	}


	@Override
	public void insertUpdate(DocumentEvent e) {
		controller.handleEvent("docChanged");
		//System.out.println("view: insertUpdate: Triggered");
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		controller.handleEvent("docChanged");
		//System.out.println("view: removeUpdate: Triggered");
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		controller.handleEvent("docChanged");
		//System.out.println("view: changedUpdate: Triggered");
		
	}



	@Override
	public void newFileDialog() {
		System.out.println("GUIview: newFileDialog() - Empty method");
		
	}


	@Override
	public void initGUI() {
		System.out.println("GUI.initGUI();");
		gui.initGUI();
		
	}

}
