import java.awt.Dimension;
import java.text.ParseException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.colorchooser.*;
import java.awt.Color;

public class EditGUIPanel extends JPanel {
	
	private JTextField widthField;
	private JTextField heightField;
	private JTextField lineWidthField;

	public EditGUIPanel(JButton editConfirmBtn, JButton chooseLineColorBtn, JButton chooseAreaColorBtn) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Edit shape");
		
		JLabel widthLabel = new JLabel("Width:");
		widthField = new JTextField();
		widthField.setMaximumSize(new Dimension(Integer.MAX_VALUE, widthField.getPreferredSize().height));
		
		JLabel heightLabel = new JLabel("Height:");
		heightField = new JTextField();
		heightField.setMaximumSize(new Dimension(Integer.MAX_VALUE, heightField.getPreferredSize().height));
		
		JLabel lineWidthLabel = new JLabel("Line width:");
		lineWidthField = new JTextField();
		lineWidthField.setMaximumSize(new Dimension(Integer.MAX_VALUE, lineWidthField.getPreferredSize().height));
		
		
		JLabel lineColorLabel = new JLabel("Line Color:");
		JLabel areaColorLabel = new JLabel("Area Color:");

		
		JSeparator divider = new JSeparator();
		
		
		this.add(titleLabel);
		this.add(widthLabel);
		this.add(widthField);
		this.add(heightLabel);
		this.add(heightField);
		this.add(lineWidthLabel);
		this.add(lineWidthField);
		this.add(lineColorLabel);
		this.add(chooseLineColorBtn);
		this.add(areaColorLabel);
		this.add(chooseAreaColorBtn);
		this.add(divider);
		this.add(editConfirmBtn);
		
		
		
	}

	public int getWidthFieldText() {
		try {
			
			int width = Integer.parseInt(widthField.getText());
			return width;
		}catch(NumberFormatException e) {
			System.out.println("EditGUIPanel: "+e);
		}
		return -1;
		
	}

	public void setWidthField(JTextField widthField) {
		this.widthField = widthField;
	}

	public int getHeightFieldText() {
		try {
			
			int height = Integer.parseInt(heightField.getText());
			return height;
		}catch(NumberFormatException e) {
			System.out.println("EditGUIPanel: "+e);
		}
		return -1;
		
	}

	public void setHeightField(JTextField heightField) {
		this.heightField = heightField;
	}

	public int getLineWidthFieldText() {
		try {
			
			int lineWidth = Integer.parseInt(lineWidthField.getText());
			return lineWidth;
		}catch(NumberFormatException e) {
			System.out.println("EditGUIPanel: "+e);
		}
		return -1;
		
	}

	public void setLineWidthField(JTextField lineWidthField) {
		this.lineWidthField = lineWidthField;
	}

}
