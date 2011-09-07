package ro.alexbolboaca.FindDuplicateFiles;

public class DuplicateSeeker {

	private final Path path;

	public DuplicateSeeker(Path path) {
		this.path = path;
	}

	public boolean seek() {
		path.checkExists();
		return false;
	}
	
	
}
