import java.util.ArrayList;

public abstract class view {
	protected Controller controller;
	public view (Controller c) {
		this.controller = c;
	}
	
	public abstract void initGUI();
	public abstract void updateTextArea(customFile openFile);
	public abstract String getTextContent();
	public abstract ArrayList<String> openFileDialog();
	public abstract int promptSaveChecker();
	public abstract ArrayList<String> saveFileDialog();
	public abstract void newFileDialog();

}
