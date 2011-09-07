package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.rules.*;


public class FindDuplicateFilesTests {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void setup(){
	}
	
	@Test
	public void emptyFolderHasNoDuplicates()
	{
		Folder emptyFolder = new Folder();
		assertTrue(emptyFolder.hasNoDuplicates());
	}
	
	@Test
	public void emptyFolderHasNoDuplicatesAlex(){

		DuplicateSeeker seeker = new DuplicateSeeker(new Path("doesn't matter"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test
	public void throwsExceptionIfFolderDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Folder nonExistingFolder doesn't exist");

		DuplicateSeeker seeker = new DuplicateSeeker(new Path("nonExistingFolder"));
		
		seeker.seek();
	}
	
	@Test
	public void throwsExceptionIfAnotherFolderDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Folder anotherNonExistingFolder doesn't exist");
		
		DuplicateSeeker seeker = new DuplicateSeeker(new Path("anotherNonExistingFolder"));
		
		seeker.seek();
	}
	
	class Path{
		List<String> nonExistentFolderPaths;
		public String folderPath;
		
		public Path(String folderPath){
			nonExistentFolderPaths = new ArrayList<String>();
			nonExistentFolderPaths.add("nonExistingFolder");
			nonExistentFolderPaths.add("anotherNonExistingFolder");
			this.folderPath = folderPath;
		}
		
		public boolean exists(){
			return !nonExistentFolderPaths.contains(folderPath);
		}

	}
}
