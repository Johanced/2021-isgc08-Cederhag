import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import se.kau.isgc08.lab4.model.DrawingComposite;
import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.view.DrawingPanel;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class View extends JFrame implements ActionListener {
	private Controller c;
	private DrawingUtil DU;
	private JPanel mainPanel;
	private DrawingPanel DrawPanel;
	private MouseEventHandler MouseHandler;
	
	public View(Controller c) {
		this.c = c;
		DU = new DrawingUtil();
		
		initGUI();
		// Menubar for additional functionlity -> File handling etc..
		// initMenuBar();
		
		// Handle mouse events!
		MouseHandler = new MouseEventHandler(DrawPanel, this);
		
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
		this.setVisible(true);
	}
	
	public void initGUI() {
		mainPanel = new JPanel(new BorderLayout());
		JPanel btnPanelSouth = new JPanel(new FlowLayout());
		JPanel btnPanelNorth = new JPanel(new FlowLayout());
		
		JPanel editPanelEast = new JPanel();
		editPanelEast.setLayout(new BoxLayout(editPanelEast, BoxLayout.Y_AXIS));
		JLabel label1 = new JLabel("PlaceHolders;");
		JButton Btn1 = new JButton("Color");
		JButton Btn2 = new JButton("AreaColor");
		JButton Btn3 = new JButton("Width");
		JButton Btn4 = new JButton("Height");
		editPanelEast.add(label1);
		editPanelEast.add(Btn1);
		editPanelEast.add(Btn2);
		editPanelEast.add(Btn3);
		editPanelEast.add(Btn4);
		
		JButton lineBtn = new JButton("Line");
		lineBtn.addActionListener(this);
		lineBtn.setActionCommand("Line");
		btnPanelNorth.add(lineBtn);
		
		JButton RectBtn = new JButton("Rect");
		RectBtn.addActionListener(this);
		RectBtn.setActionCommand("Rect");
		btnPanelNorth.add(RectBtn);
		
		JButton CircleBtn = new JButton("Circle");
		CircleBtn.addActionListener(this);
		CircleBtn.setActionCommand("Circle");
		btnPanelNorth.add(CircleBtn);
		
		JButton test1Btn = new JButton("Test 1");
		test1Btn.addActionListener(this);
		test1Btn.setActionCommand("1");
		btnPanelSouth.add(test1Btn);
		
		JButton saveBtn= new JButton("Save");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("2");
		btnPanelSouth.add(saveBtn);
		
		JButton openBtn= new JButton("Open");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("3");
		btnPanelSouth.add(openBtn);
		
		mainPanel.add(btnPanelNorth, BorderLayout.NORTH);
		mainPanel.add(btnPanelSouth, BorderLayout.SOUTH);
		mainPanel.add(editPanelEast, BorderLayout.EAST);
		DrawPanel = new DrawingPanel(new DrawingContainer());
		DrawPanel.setBackground(Color.WHITE);
		mainPanel.add(DrawPanel, BorderLayout.CENTER);
	}
	public void initMenuBar() {
		viewMenuBar VMenuBar = new viewMenuBar(this);
		this.setJMenuBar(VMenuBar.initMenuBar());
	}
	
	public void drawResult(DrawingContainer DC) {
		DrawPanel.setDc(DC);
		MouseHandler.addObjectsMouseListenerList(DC);
		this.repaint();
		//this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		c.handleEvent(btnClicked);
		
	}

}
