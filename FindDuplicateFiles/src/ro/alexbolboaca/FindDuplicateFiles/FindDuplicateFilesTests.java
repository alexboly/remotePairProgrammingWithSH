package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.rules.*;


public class FindDuplicateFilesTests {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	List<String> nonExistentFolderPaths;

	@Before
	public void setup(){
		nonExistentFolderPaths = new ArrayList<String>();
		nonExistentFolderPaths.add("nonExistingFolder");
		nonExistentFolderPaths.add("anotherNonExistingFolder");
	}
	
	@Test
	public void emptyFolderHasNoDuplicates()
	{
		Folder emptyFolder = new Folder();
		assertTrue(emptyFolder.hasNoDuplicates());
	}
	
	@Test
	public void emptyFolderHasNoDuplicatesAlex(){

		DuplicateSeeker seeker = new DuplicateSeeker("doesn't matter", new Path());
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test
	public void throwsExceptionIfFolderDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Folder nonExistingFolder doesn't exist");

		DuplicateSeeker seeker = new DuplicateSeeker("nonExistingFolder", new Path());
		
		seeker.seek();
	}
	
	@Test
	public void throwsExceptionIfAnotherFolderDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Folder anotherNonExistingFolder doesn't exist");
		
		DuplicateSeeker seeker = new DuplicateSeeker("anotherNonExistingFolder", new Path());
		
		seeker.seek();
	}
	
	class Path{
		List<String> nonExistentFolderPaths;

		public Path(){
			nonExistentFolderPaths = new ArrayList<String>();
			nonExistentFolderPaths.add("nonExistingFolder");
			nonExistentFolderPaths.add("anotherNonExistingFolder");
		}
		
		public boolean exists(String path){
			return !nonExistentFolderPaths.contains(path);
		}
	}
}
