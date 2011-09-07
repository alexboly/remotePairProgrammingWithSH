package ro.alexbolboaca.FindDuplicateFiles;

import ro.alexbolboaca.FindDuplicateFiles.FindDuplicateFilesTests.Path;

public class DuplicateSeeker {

	private final Path path;

	public DuplicateSeeker(Path path) {
		this.path = path;
	}

	public boolean seek() {
		return path.exists();
	}
}
