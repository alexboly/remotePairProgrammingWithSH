package ro.alexbolboaca.FindDuplicateFiles;

import ro.alexbolboaca.FindDuplicateFiles.FindDuplicateFilesTests.Path;

public class DuplicateSeeker {

	private final Path path;
	private final String folderPath;

	public DuplicateSeeker(String folderPath, Path path) {
		this.folderPath = folderPath;
		this.path = path;
	}

	public boolean seek() {
		if(!path.exists(folderPath)){
			throw new RuntimeException("Folder " + folderPath + " doesn't exist.");			
		}

		return false;
	}
}
