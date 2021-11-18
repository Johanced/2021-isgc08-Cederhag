
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class View implements ActionListener {

	private JFrame mainFrame;
	private JTextArea textArea;
	private Controller controller;

	public View(Controller c) {
		this.controller = c;
		
		initGUI();
	}
	
	public void initTextAreaListener(DocumentListener dcListener) {
		textArea.getDocument().addDocumentListener(dcListener);
	}
	
	public void initGUI() {
		mainFrame = new JFrame("Notepad - Filnamn");
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
		
		mainFrame.setJMenuBar(menuBar);
		mainFrame.add(textArea);
		mainFrame.setSize(500,650);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.show();
	}
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
		    System.out.println("view: openFileDialog: Selected file: " + file.getAbsolutePath());
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
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    return customfile;
		}
		
		return null;	
	}
	public void updateTextArea(customFile file) {
		
		textArea.setText(file.getFileContent());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		controller.actionPerformed(btnClicked);
		
	}

}
