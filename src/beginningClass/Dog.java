package beginningClass;

public class Dog {
	private String name;
	private int age;
	private int weight;
	
	public Dog(String name, int age, int weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	
	public String speak() {
		return "Woof!";
	}
	
	public String toString() {
		return "My name is " + name + ". I am " + age + " years old. I weigh " + this.weight + " pounds.";
	}
	
	public static void main(String[] args) {
		Dog myDog = new Dog("Doggo", 1, 1234567890);
		
		System.out.println(myDog.speak());
		System.out.println(myDog.toString());
		System.out.println(myDog); //toString() is a special method, when you print the object, java looks for the toString() method to print that
	}
}