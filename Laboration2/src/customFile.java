
public class customFile {
	private String filePath;
	private String fileContent;
	private String fileName;
	private boolean hasChanged = false;
	
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
	public boolean hasChanged() {
		return hasChanged;
	}
	public void setHasChanged(boolean hasChanged) {
		this.hasChanged = hasChanged;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
