package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.*;


public class FindDuplicateFilesTests {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
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
	
	@Test
	public void throwsExceptionIfAnotherFolderDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Folder anotherNonExistingFolder doesn't exist");
		
		DuplicateSeeker seeker = new DuplicateSeeker("anotherNonExistingFolder");
		
		seeker.seek();
	}
}
