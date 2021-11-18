import java.io.File;

public class Controller {
	private View view;
	private Model model;
	
	public Controller() {
		this.view = new View(this);
		this.model = new Model();	
	}

	public void actionPerformed(String btnClicked) {
		System.out.println("controller : "+btnClicked);
		customFile file = new customFile();
		switch(btnClicked) {
			case "save": file = view.saveFileDialog();
				System.out.println("save: controller: filepath= "+file.getFilePath());
				model.saveFile(file);
			break;
			case "open": file = view.openFileDialog();
				System.out.println("open: controller: filepath= "+file.getFilePath());
				view.updateTextArea(model.openFile(file));
			break;
		}
	}
	
	public static void main(String[] args) {
		new Controller();

	}

}
