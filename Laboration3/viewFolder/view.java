
public abstract class view {

	public abstract void initGUI();
	public abstract void updateTextArea(customFile openFile);
	public abstract String getTextContent();
	public abstract customFile openFileDialog();
	public abstract int promptSaveChecker();
	public abstract customFile saveFileDialog();
	public abstract void newFileDialog();

}
