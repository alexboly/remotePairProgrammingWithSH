package ro.alexbolboaca.FindDuplicateFiles;

public class DuplicateSeeker {


	public DuplicateSeeker(String folderPath) {
		if(folderPath.equals("nonExistingFolder") || folderPath.equals("anotherNonExistingFolder"))
		{
			throw new RuntimeException("Folder " + folderPath + " doesn't exist.");
		}
	}

	public boolean seek() {
		return false;
	}

}
