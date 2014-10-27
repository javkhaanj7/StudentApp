package mum.edu.javkhaanj7.studentapp;

public class StudentInfo {

	private String name;
	private String country;
	private String imageName;
	private String bioPath;
	private String soundPath;
	
	public StudentInfo(String name, String country, String imageName, String bioPath, String soundPath){
		this.name = name;
		this.country = country;
		this.imageName = imageName;
		this.bioPath = bioPath;
		this.soundPath = soundPath;
	}

	public String getBioPath() {
		return bioPath;
	}

	public void setBioPath(String bioPath) {
		this.bioPath = bioPath;
	}

	public String getName() {
		return name;
	}

	public String getSoundPath() {
		return soundPath;
	}

	public void setSoundPath(String soundPath) {
		this.soundPath = soundPath;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
    public String toString() {
        return this.name + "\n" + this.country;
    }
	
}
