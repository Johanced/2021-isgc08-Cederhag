import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.colorchooser.*;
import java.awt.Color;

public class EditGUIPanel extends JPanel {
	
	public EditGUIPanel(JButton editConfirmBtn, JButton chooseLineColorBtn, JButton chooseAreaColorBtn) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel titleLabel = new JLabel("Edit shape");
		
		JLabel widthLabel = new JLabel("Width:");
		JTextField widthField = new JTextField();
		widthField.setMaximumSize(new Dimension(Integer.MAX_VALUE, widthField.getPreferredSize().height));
		
		JLabel heightLabel = new JLabel("Height:");
		JTextField heightField = new JTextField();
		heightField.setMaximumSize(new Dimension(Integer.MAX_VALUE, heightField.getPreferredSize().height));
		
		JLabel lineWidthLabel = new JLabel("Line width:");
		JTextField lineWidthField = new JTextField();
		lineWidthField.setMaximumSize(new Dimension(Integer.MAX_VALUE, lineWidthField.getPreferredSize().height));
		
		
		JLabel lineColorLabel = new JLabel("Line Color:");
		// Color Chooser
		// BUTTON
		JLabel areaColorLabel = new JLabel("Area Color:");
		// Color Chooser
		// BUTTON
		
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

}
