package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;
import org.junit.*;


public class FindDuplicateFilesTests {

	@Test
	public void emptyFolderHasNoDuplicates()
	{
		Folder emptyFolder = new Folder();
		assertTrue(emptyFolder.hasNoDuplicates());
	}
	
	@Test
	public void emptyFolderHasNoDuplicatesAlex(){
		DuplicateSeeker seeker = new DuplicateSeeker("doesn't matter");
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test(expected=RuntimeException.class)
	public void throwsExceptionIfFolderDoesntExist(){
		DuplicateSeeker seeker = new DuplicateSeeker("nonExistingFolder");
		
		seeker.seek();
	}
	
	@Test(expected=RuntimeException.class)
	public void throwsExceptionIfAnotherFolderDoesntExist(){
		DuplicateSeeker seeker = new DuplicateSeeker("anotherFolder");
		
		seeker.seek();
	}
}
