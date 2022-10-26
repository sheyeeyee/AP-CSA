package veryBeginning;

public class AboutMe {
	private String name;
	private String school;
	private int age;
	
	public AboutMe(String name, String school, int age) {
		this.name = name;
		this.school = school;
		this.age = age;
	}
	
	public String myName() {
		return name;
	}
	
	public String mySchool() {
		return school;
	}
	
	public int myAge() {
		return age;
	}
	
	public static void main(String[] args) {
		AboutMe me = new AboutMe("Shelley Wei", "Beckman High School", 17);
		System.out.println("My name is " + me.myName() + ", and I attend " + me.mySchool() + ". I am " + me.myAge() + " years old.");
	}
}