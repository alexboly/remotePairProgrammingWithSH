package ro.alexbolboaca.FindDuplicateFiles;

import java.util.List;

class Path{
	List<String> existentPaths;
	private String path;
	
	public Path(List<String> existentPaths, String path){
		this.existentPaths = existentPaths;
		this.path = path;
	}
	
	public void checkExists(){
		if(!existentPaths.contains(path)){
			throw new RuntimeException("Path " + path + " doesn't exist.");			
		}
	}
}
