package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.rules.*;


public class FindDuplicateFilesTests {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	FileStub fileForTests;
	
	@Before
	public void setup(){
		fileForTests = new FileStub();
	}

	
	@Test
	public void emptyPathHasNoDuplicates(){		
		DuplicateSeeker seeker = new DuplicateSeeker(new Path(fileForTests,"emptyFolder"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test
	public void anotherEmptyPathHasNoDuplicates(){

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(fileForTests,"anotherEmptyFolder"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}

	@Test
	public void andAnotherEmptyPathHasNoDuplicates(){

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(fileForTests,"andAnotherEmptyFolder"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}

	@Test
	public void throwsExceptionIfPathDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Path nonExistingPath doesn't exist");

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(fileForTests,"nonExistingPath"));
		
		seeker.seek();
	}
	
	@Test
	public void throwsExceptionIfAnotherPathDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Path anotherNonExistingPath doesn't exist");
		
		DuplicateSeeker seeker = new DuplicateSeeker(new Path(fileForTests,"anotherNonExistingPath"));
		
		seeker.seek();
	}
}
