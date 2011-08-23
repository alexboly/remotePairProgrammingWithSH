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
		DuplicateSeeker seeker = new DuplicateSeeker("test/");
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
}
