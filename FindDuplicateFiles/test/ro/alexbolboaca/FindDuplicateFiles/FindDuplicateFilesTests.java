package ro.alexbolboaca.FindDuplicateFiles;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.rules.*;


public class FindDuplicateFilesTests {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	List<String> existentPaths = new ArrayList<String>();

	@Before
	public void setup(){
		existentPaths.add("emptyFolder");
	}

	
	@Test
	public void emptyPathHasNoDuplicates(){

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(existentPaths,"emptyFolder"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test
	public void anotherEmptyPathHasNoDuplicates(){

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(existentPaths,"anotherEmptyFolder"));
		
		boolean foundDuplicates = seeker.seek();
		
		assertFalse(foundDuplicates);
	}
	
	@Test
	public void throwsExceptionIfPathDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Path nonExistingPath doesn't exist");

		DuplicateSeeker seeker = new DuplicateSeeker(new Path(existentPaths,"nonExistingPath"));
		
		seeker.seek();
	}
	
	@Test
	public void throwsExceptionIfAnotherPathDoesntExist(){
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Path anotherNonExistingPath doesn't exist");
		
		DuplicateSeeker seeker = new DuplicateSeeker(new Path(existentPaths,"anotherNonExistingPath"));
		
		seeker.seek();
	}
}
