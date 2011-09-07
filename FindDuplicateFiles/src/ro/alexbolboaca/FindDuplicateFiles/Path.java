package ro.alexbolboaca.FindDuplicateFiles;

class Path{
	private String path;
	private FileStub fileForTests;
	
	public Path(FileStub fileForTests, String path){
		this.fileForTests = fileForTests;
		this.path = path;
	}
	
	public void checkExists(){
		if(!fileForTests.fileExists(path)){
			throw new RuntimeException("Path " + path + " doesn't exist.");			
		}
	}
}
