package spring5_webmvc_study.survey;

public class Respondent {
	private int age;
    private String location;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

	@Override
	public String toString() {
		return String.format("Respondent [age=%s, location=%s]", age, location);
	}
    
    
    
}
