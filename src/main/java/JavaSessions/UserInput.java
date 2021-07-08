package JavaSessions;

import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
	    try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Enter username");

			String userName = myObj.nextLine();  // Read user input
			System.out.println("Username is: " + userName);  // Output user input
		}
	  }

}
