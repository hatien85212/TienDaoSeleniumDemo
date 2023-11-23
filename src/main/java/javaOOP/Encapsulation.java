package javaOOP;

public class Encapsulation {
	public static void main(String[] args) {
		Person myObj = new Person(); //initiate object from Person class
	    myObj.name = "John";  // error, can not access to hidden data. Increased security of data
	    myObj.title = "Mr";
	    myObj.age = 38;
	    System.out.println(myObj.name); // error: private field. The field Person.name is not visible 
	    System.out.println(myObj.title); // public = access from anywhere
	    System.out.println(myObj.age); // default = access within the same package
	}
}
