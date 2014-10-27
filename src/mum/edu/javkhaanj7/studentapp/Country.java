package mum.edu.javkhaanj7.studentapp;

public class Country {
	
	private String name;
	private String keyNames[]; 
	private String flagImagePath;
	
	public Country(String name, String keyNames[], String flagImagePath){
		this.name = name;
		this.keyNames = keyNames;
		this.flagImagePath = flagImagePath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getKeyNames() {
		return keyNames;
	}

	public void setKeyNames(String[] keyNames) {
		this.keyNames = keyNames;
	}

	public String getFlagImagePath() {
		return flagImagePath;
	}

	public void setFlagImagePath(String flagImagePath) {
		this.flagImagePath = flagImagePath;
	}

}
