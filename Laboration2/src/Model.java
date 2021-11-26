import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Model {
	private customFile currfile = new customFile();
	
	public Model() {
		createNewFile();
	}
	public customFile createNewFile() {
		customFile file = new customFile();
		setCurrfile(file);
		return file;
	}
	public void saveFile(customFile file) {
		  try {
			  
			  File tempFile = new File(file.getFilePath());
		      FileWriter myWriter = new FileWriter(tempFile, StandardCharsets.UTF_8);
		      myWriter.write(file.getFileContent());
		      myWriter.close();
		      System.out.println("Model: saveFile: Wrote to file. ");
		    } catch (IOException e) {
		      System.out.println("Model: saveFile: Error.");
		      e.printStackTrace();
		    }
	}
	
	public customFile openFile(customFile file) {
		char[] buffer = new char[4088];
		
		try {
			customFile cFile = new customFile();
			FileReader reader = new FileReader(file.getFilePath(), StandardCharsets.UTF_8);
			reader.read(buffer);
			String slask = new String(buffer);
			slask = slask.trim();
			cFile.setFileContent(slask);
			cFile.setFileName(file.getFileName());
			reader.close();
			System.out.println("Model: openfile: read from file. ");
			
			return cFile;
		}catch(Exception e) {
			System.out.println("Model: openfile: Error.");
			return null;
		}
	
	}
	
	public int modelErrorChecker(String theCase) {
		
		if(theCase == "checkChanged") {
			if(currfile.hasChanged() == true) {
				System.out.println("modelErrorChecker : hasChanged == true");
				return 2;
			}
		}
		if(theCase == "save") {
			if(currfile.getFilePath() == null) {
				System.out.println("RETURN CODE1 = 1");
				return 1;
			}else if(currfile.getFilePath().isEmpty()) {
				return 1;
			}else if(currfile.getFilePath() == " ") {
				return 1;
			}else if(currfile.getFilePath() == "null") {
				return 1;
			}else {
				return 0;
			}
		}
		return 0;
		
	}
	public customFile getCurrfile() {
		return currfile;
	}
	public void setCurrfile(customFile currfile) {
		this.currfile = currfile;
	}
	

}
