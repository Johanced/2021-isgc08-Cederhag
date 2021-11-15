import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class Controller implements ActionListener {
	private View view;
	private Model model;
	
	public Controller() {
		this.view = new View(this);
		this.model = new Model();
		
		view.initGUI();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println("Controller: command: "+command);
		switch(command) {
		case "new":
			break;
		case "open":
			break;
		case "save":
			break;
		case "saveAs":
			break;
		case "exit":
			break;
		}
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Controller();

	}

}
