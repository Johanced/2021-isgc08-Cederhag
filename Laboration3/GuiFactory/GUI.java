import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;

public interface GUI {
	public static final JFrame mainFrame = new JFrame();
	public static final JTextArea textArea = new JTextArea();
	
	public void initGUI();
	public void actionPerformed(ActionEvent e);
	public void insertUpdate(DocumentEvent e);
	public void removeUpdate(DocumentEvent e);
	public void changedUpdate(DocumentEvent e);

}
