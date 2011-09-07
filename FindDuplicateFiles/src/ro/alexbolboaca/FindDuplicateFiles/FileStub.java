package ro.alexbolboaca.FindDuplicateFiles;

import java.util.ArrayList;
import java.util.List;

public class FileStub  {
	private List<String> existentPaths;

	public FileStub (){
		existentPaths = new ArrayList<String>();
		existentPaths.add("emptyFolder");
		existentPaths.add("anotherEmptyFolder");
		existentPaths.add("andAnotherEmptyFolder");
	}
	
	public boolean fileExists(String path) {
		return existentPaths.contains(path);
	}
}
