package javaOOP;

public class Person {//modifier for the class: only public, abstract & final are permitted
	private String name; // private = restricted access, only access within a class
	public String title; // public = access anywhere
	int age; //default = access within the same packag
	
	// Getter
	public String getName() {
		return name;
	}

	// Setter
	public void setName(String newName) {
		this.name = newName;
	}

	public static void main(String[] args) {
		Person myObj = new Person(); // initiate object from Person class
		myObj.name = "John"; // error
		myObj.title = "Mr";
		myObj.age =  38;
		System.out.println(myObj.name); // private can be accessed within class
		System.out.println(myObj.title); 
		System.out.println(myObj.age); 
	}

}
