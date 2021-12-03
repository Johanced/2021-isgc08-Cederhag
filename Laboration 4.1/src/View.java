import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.Line;
import se.kau.isgc08.lab4.view.DrawingPanel;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class View extends JFrame implements ActionListener {
	Controller c;
	DrawingUtil DU;
	private JPanel mainPanel;
	
	public View(Controller c) {
		this.c = c;
		DU = new DrawingUtil();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		JPanel btnPanel = new JPanel(new FlowLayout());
		
		JButton test1Btn = new JButton("Test 1");
		test1Btn.addActionListener(this);
		test1Btn.setActionCommand("1");
		btnPanel.add(test1Btn);
		
		JButton saveBtn= new JButton("Save");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("2");
		btnPanel.add(saveBtn);
		
		JButton openBtn= new JButton("Open");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("3");
		btnPanel.add(openBtn);
		
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		
		this.add(mainPanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void drawResult(DrawingContainer DC) {
		DrawingPanel DrawPanel = new DrawingPanel(DC);
		mainPanel.add(DrawPanel, BorderLayout.CENTER);
		this.repaint();
		//this.setSize(500, 500); 
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		c.handleEvent(btnClicked);
		
	}


}
