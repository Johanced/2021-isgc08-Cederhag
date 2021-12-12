import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import se.kau.isgc08.lab4.model.DrawingContainer;
import se.kau.isgc08.lab4.model.DrawingShape;
import se.kau.isgc08.lab4.model.shapeSettings;
import se.kau.isgc08.lab4.view.DrawingPanel;
import se.kau.isgc08.lab4.view.DrawingUtil;

public class View extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -932726630757368132L;
	private Controller c;
	private DrawingUtil DU;
	private JPanel mainPanel;
	private DrawingPanel DrawPanel;
	private MouseEventHandler MouseHandler;
	private colorPickerHandler colorPickerHandler;
	private EditGUIPanel editGUIPanel;
	
	public View(Controller c) {
		this.c = c;
		setDrawUtil(new DrawingUtil());
		
		initGUI();
		// Menubar for additional functionlity -> File handling etc..
		// initMenuBar();
		
		// Handle mouse events!
		MouseHandler = new MouseEventHandler(DrawPanel, this);
		
		colorPickerHandler = new colorPickerHandler(this);
		
		this.add(mainPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setVisible(true);
	}
	
	public void initGUI() {
		mainPanel = new JPanel(new BorderLayout());
		JPanel btnPanelSouth = new JPanel(new FlowLayout());
		JPanel btnPanelNorth = new JPanel(new FlowLayout());
		
		JPanel editPanelEast = new JPanel();
		editPanelEast.setLayout(new BoxLayout(editPanelEast, BoxLayout.Y_AXIS));
		
		JButton chooseLineColorBtn = new JButton("Line Color");
		chooseLineColorBtn.addActionListener(this);
		chooseLineColorBtn.setActionCommand("LineColor");
		JButton chooseAreaColorBtn = new JButton("Area Color");
		chooseAreaColorBtn.addActionListener(this);
		chooseAreaColorBtn.setActionCommand("AreaColor");
		JButton editChangesBtn = new JButton("Confirm changes");
		editGUIPanel = new EditGUIPanel(editChangesBtn,chooseLineColorBtn, chooseAreaColorBtn);
		editChangesBtn.addActionListener(this);
		editChangesBtn.setActionCommand("ConfirmChanges");

		
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
		
		JButton RemoveBtn = new JButton("Remove");
		RemoveBtn.addActionListener(this);
		RemoveBtn.setActionCommand("removeShape");
		btnPanelNorth.add(RemoveBtn);
		
		JButton test1Btn = new JButton("Clear Panel");
		test1Btn.addActionListener(this);
		test1Btn.setActionCommand("clearPanel");
		btnPanelSouth.add(test1Btn);
		
		JButton saveBtn= new JButton("Save");
		saveBtn.addActionListener(this);
		saveBtn.setActionCommand("save");
		btnPanelSouth.add(saveBtn);
		
		JButton openBtn= new JButton("Open");
		openBtn.addActionListener(this);
		openBtn.setActionCommand("open");
		btnPanelSouth.add(openBtn);
		
		mainPanel.add(btnPanelNorth, BorderLayout.NORTH);
		mainPanel.add(btnPanelSouth, BorderLayout.SOUTH);
		mainPanel.add(editGUIPanel, BorderLayout.EAST);
		DrawPanel = new DrawingPanel(new DrawingContainer());
		DrawPanel.setBackground(Color.WHITE);
		mainPanel.add(DrawPanel, BorderLayout.CENTER);
	}
	
	public void drawResult(DrawingContainer DC) {
		DrawPanel.setDc(DC);
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnClicked = e.getActionCommand();
		System.out.println("view : "+btnClicked);
		c.handleEvent(btnClicked);
		
	}

	public DrawingUtil getDrawUtil() {
		return DU;
	}

	public void setDrawUtil(DrawingUtil dU) {
		DU = dU;
	}
	public Color showColorPicker() {
		return colorPickerHandler.showColorPicker();
	}
	
	public void updateEditPanelSettings(DrawingShape shape) {
		//TODO; Uppdatera editGuiPanels settings till den nuvarande selected Shape!
		// Sker efter Shape är selected
		if(shape != null) {
			editGUIPanel.setWidthFieldText(shape.getWidth());
			editGUIPanel.setHeightField(shape.getHeight());
			editGUIPanel.setLineWidthField(shape.getLineWidth());
			editGUIPanel.setButtonAreaColor(shape.getAreaColor());
			editGUIPanel.setButtonLineColor(shape.getLineColor());
		}
		
	}
	public void triggerGetShapeAtCoords() {
		c.handleEvent("getShapeAtCoords");
	}
	public void triggerScaleShape() {
		c.handleEvent("scaleShape");
	}
	public void moveThisShape() {
		c.handleEvent("moveShape");
	}
	/*public int mouseHandlerGetx1() {
		return MouseHandler.getOffsetNewX1();	
	}
	public int mouseHandlerGety1() {
		return MouseHandler.getOffsetNewY1();	
	}
	public int mouseHandlerGetx2() {
		return MouseHandler.getLineOffsetX2();	
	}
	public int mouseHandlerGety2() {
		return MouseHandler.getLineOffsetY2();	
	}
	public String mouseHandlerGetPointType() {
		return MouseHandler.getPointType();
	}*/
	public int getScrollDirection() {
		return MouseHandler.getScrollDirection();
	}
	public int getScrollAmount() {
		return MouseHandler.getScrollAmount();
	}
	public DrawingShape getShapeAtCoords(DrawingShape shape) {
		MouseHandler.receiveShape(shape);
		return shape;
	}
	public int getMouseCoords(String code) {
		if(code == "x") {
			return MouseHandler.getMouseX();
		}
		if(code == "y") {
			return MouseHandler.getMouseY();
		}
		return -1;
	}
	public int getSelectedShapeCoords(String code) {
		if(code == "x") {
			return MouseHandler.getSelectedShapeX();
		}
		if(code == "y") {
			return MouseHandler.getSelectedShapeY();
		}
		return -1;
	}
	public void repaintView() {
		this.repaint();
	}
	public void showDialog(String message, String title, String type) {
		if(type == "Error") {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.WARNING_MESSAGE);
		}
		
	}
	public shapeSettings constructShapeSettings() {
		int x1 = MouseHandler.getSelectedShapeX();
		int y1 = MouseHandler.getSelectedShapeY();
		int width = editGUIPanel.getWidthFieldText();
		int height = editGUIPanel.getHeightFieldText();
		int lineWidth = editGUIPanel.getLineWidthFieldText();
		if(width < 1 || height < 1 || lineWidth < 1) {
			System.out.println("null settings returned");
			return null;
		}else {
			shapeSettings setting = new shapeSettings(x1,y1,width, height, lineWidth);
			
		return setting;
		}
	}

}
