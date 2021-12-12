import java.awt.*;
import javax.swing.JColorChooser;
import javax.swing.JFrame;



public class colorPickerHandler {
	private JFrame frame;
	
	public colorPickerHandler(JFrame frame) {
		this.frame = frame;  
		
	}

	public Color showColorPicker() {
		Color pickedColor=JColorChooser.showDialog(frame,"Select a color",Color.RED);
		return pickedColor;
	}
}
