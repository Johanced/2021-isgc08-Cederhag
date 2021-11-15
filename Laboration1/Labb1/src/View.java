
import javax.swing.*;
import javax.swing.event.DocumentListener;

import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {

	private JFrame mainFrame;
	private JTextArea textArea;
	private ArrayList<JComponent> ActionComponents = new ArrayList();
	private Controller controller;

	public View(Controller c) {
		this.controller = c;
	}
	
	public void initActionListener(ActionListener acListener) {
		for (JComponent comp : ActionComponents) {
			((AbstractButton) comp).addActionListener(acListener);
		}
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
		
		ActionComponents.add(menuItem1);
		ActionComponents.add(menuItem2);
		ActionComponents.add(menuItem3);
		ActionComponents.add(menuItem4);
		ActionComponents.add(menuItem9);
		ActionComponents.add(textArea);
		
		
		mainFrame.setJMenuBar(menuBar);
		mainFrame.add(textArea);
		mainFrame.setSize(500,650);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.show();
	}
}
