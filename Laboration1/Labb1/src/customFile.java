
public class customFile {
	private String filePath;
	private String fileContent;
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		if(!filePath.endsWith(".txt")) {
			this.filePath = filePath + ".txt";
		}else {
			this.filePath = filePath;
		}
		
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

}
