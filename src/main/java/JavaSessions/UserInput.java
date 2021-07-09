package JavaSessions;

import java.util.Scanner;

public class UserInput {
	static Scanner myObj = new Scanner(System.in); // Create a Scanner object

	public static void main(String[] args) {
		enterYourName();
		addInputTwoNumber();
		myObj.close();
	}

	public static void enterYourName() {
		System.out.println("Enter username");

		String userName = myObj.nextLine(); // Read user input
		System.out.println("Username is: " + userName); // Output user input
	}

	public static void addInputTwoNumber() {
		System.out.println("\n***** Add 2 numbers from the user input");

		int x, y, sum;

		System.out.println("Type a number:");
		x = myObj.nextInt(); // Read user input

		System.out.println("Type another number:");
		y = myObj.nextInt(); // Read user input

		sum = x + y; // Calculate the sum of x + y
		System.out.println("Sum is: " + sum); // Print the sum
		
	}

}
