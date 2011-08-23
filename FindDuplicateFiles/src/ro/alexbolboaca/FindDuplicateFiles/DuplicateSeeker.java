package ro.alexbolboaca.FindDuplicateFiles;

import java.util.List;

public class DuplicateSeeker {


	public DuplicateSeeker(String folderPath, List<String> folderPaths) {
				
		if(folderPaths.contains(folderPath)){
			throw new RuntimeException("Folder " + folderPath + " doesn't exist.");			
		}
	}

	public boolean seek() {
		return false;
	}

}
