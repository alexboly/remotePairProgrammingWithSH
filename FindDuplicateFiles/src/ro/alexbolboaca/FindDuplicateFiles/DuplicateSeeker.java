package ro.alexbolboaca.FindDuplicateFiles;

public class DuplicateSeeker {


	public DuplicateSeeker(String folderPath) {
		if(folderPath.equals("nonExistingFolder"))
		{
			throw new RuntimeException("nonExistingFolder doesn't exist.");
		}
	}

	public boolean seek() {
		return false;
	}

}
