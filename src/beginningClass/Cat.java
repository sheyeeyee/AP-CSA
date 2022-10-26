package beginningClass;

public class Cat {
	//turtle yertle attributes: speed, color, size, name, position
	
	//instance variables/fields **PRIVATE**
	private String name; //private means it can only be referenced in the class
	private int age;
	private String breed;
	private String color;
	private int weight;
	
	//constructor special method invoked when 'new' keyword is used, includes parameters, any cat that is made has to have these parameters
	public Cat(String name, int age, int weight) {
		this.name = name; //this. is so the code knows which one you're talking about (like the String vs this line)
		this.age = age;
		this.weight = weight;
	}
	//five-argument constructor, both constructors (above and this) can be used
	public Cat(String name, int age, int weight, String breed, String color) {
		this.name = name; //this. is so the code knows which one you're talking about (like the String vs this line)
		this.age = age;
		this.weight = weight;
		this.breed = breed;
		this.color = color;
	}
	
	//methods: actions that objects of the class can perform
	public String speak() {
		return "Meow. My name is " + name + "."; //this method returns a string (Meow and the name)
	}
	
	//objects
	public static void main(String[] args) {
		//create a Cat object named myCat
		Cat myCat = new Cat("sherk", 2, 10); //blueprint for creating new objects, refer back to the constructor
		System.out.println(myCat.name);
		System.out.println(myCat.speak());
		
		//create a Cat object named otherCat
		Cat otherCat = new Cat("the other one...", 3, 110000);
		System.out.println(otherCat.name);
		System.out.println(otherCat.speak());
		
		//create a Cat object with five arguments
		Cat bigCat = new Cat("the OTHER one", 3, 10, "Polynesian", "green");
		System.out.println(bigCat.name);
		System.out.println(bigCat.speak());
		System.out.println("I am a " + bigCat.breed + " cat.");
		System.out.println("I have " + bigCat.color + " fur.");
	}
}