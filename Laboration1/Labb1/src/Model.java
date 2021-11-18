import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Model {
	
	
	public void createNewFile() {
		
	}
	public void saveFile(customFile file) {
		  try {
			  File tempFile = new File(file.getFilePath());
		      FileWriter myWriter = new FileWriter(tempFile, StandardCharsets.UTF_8);
		      myWriter.write(file.getFileContent());
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public customFile openFile(customFile file) {
		char[] buffer = new char[2048];
		
		try {
			customFile cFile = new customFile();
			FileReader reader = new FileReader(file.getFilePath(), StandardCharsets.UTF_8);
			reader.read(buffer);
			String slask = new String(buffer);
			cFile.setFileContent(slask);
			
			reader.close();
			return cFile;
		}catch(Exception e) {
			System.out.println("error model: openfile ln:45");
			return null;
		}
	
	}
	

}
