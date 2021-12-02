import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

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
	public void saveFile() {
		  try {
			  //currfile.setFilePath(fileHolder.get(0));
			  //currfile.setFileName(fileHolder.get(1));
			  //currfile.setFileContent(fileHolder.get(2));
			  
			  File tempFile = new File(currfile.getFilePath());
		      FileWriter myWriter = new FileWriter(tempFile, StandardCharsets.UTF_8);
		      myWriter.write(currfile.getFileContent());
		      myWriter.close();
		      System.out.println("Model: saveFile: Wrote to file. ");
		      currfile.setHasChanged(false);
		    } catch (IOException e) {
		      System.out.println("Model: saveFile: Error.");
		      e.printStackTrace();
		    }
	}
	
	public customFile openFile(ArrayList<String> list) {
		char[] buffer = new char[4088];
		
		try {
			customFile cFile = new customFile();
			FileReader reader = new FileReader(list.get(0), StandardCharsets.UTF_8);
			reader.read(buffer);
			String slask = new String(buffer);
			slask = slask.trim();
			cFile.setFileContent(slask);
			cFile.setFileName(list.get(1));
			this.setCurrfile(cFile);
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
				System.out.println("modelErrorChecker: File has changed.");
				return 2;
			}
		}
		if(theCase == "save") {
			if(currfile.getFilePath() == null) {
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