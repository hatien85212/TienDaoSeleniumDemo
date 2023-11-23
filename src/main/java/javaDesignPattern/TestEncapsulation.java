package javaDesignPattern;

import javaOOP.Person;

public class TestEncapsulation {
	public static void main(String[] args) {
		Person myObj = new Person(); //initiate object from Person class
	    myObj.name = "John";  // error
	    myObj.title = "Mr";
	    myObj.age = 38; // Unable access from different package
	    System.out.println(myObj.name); // error: The field Person.name is not visible 
	    System.out.println(myObj.title); 
	    System.out.println(myObj.age); // error: The field Person.name is not visible 
	}
}
