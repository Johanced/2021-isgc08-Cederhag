import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GUIstandard implements GUI, ActionListener, DocumentListener {

	private JFrame mainFrame;
	private JTextArea textArea;
	private ArrayList<JComponent> JCompList;
	private Controller c;

	public GUIstandard(Controller c) {
		this.c = c;
	}
	@Override
	public void initGUI() {
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
		
	}

	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		c.handleEvent(btnClicked);	
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		c.handleEvent("docChanged");
		//System.out.println("view: insertUpdate: Triggered");	
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		c.handleEvent("docChanged");
		//System.out.println("view: removeUpdate: Triggered");	
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		c.handleEvent("docChanged");
		//System.out.println("view: changedUpdate: Triggered");
		
	}
	
}
