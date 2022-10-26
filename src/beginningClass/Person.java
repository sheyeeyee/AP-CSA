package beginningClass;

public class Person {
	
	//every object will have these three parameters, instance variables
	private String name;
	private int age;
	private int weight;
	
	//constructor: special method that is called
	public Person(String name, int age, int weight) {
		//this. are the fields attached to the object, not the parameters
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	//method: an action that objects/instances of the class can perform
	//this public class can be run outside of the class
	public String speak() {
		//returning a string
		return "Hey, dude!";
	}
	
	//run object.getField in other classes to run these
	//auto-write this by right-click > source > Generate getters and setters...
	public String getName(String password) {
		if (password.equals("friend")) return name;
		return "Wrong password";
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	//start adding objects and actions here
	public static void main(String[] args) {
		Person me = new Person("Shelley", 17, 12973);
		Person friend = new Person("The Friend", 16, 100);
		
		System.out.println(me.weight);
		System.out.println(friend.weight);
	}
}