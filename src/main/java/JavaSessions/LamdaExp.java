package JavaSessions;

import java.util.ArrayList;
import java.util.function.Consumer;

/*
 * Lambda expression is a short block of code which takes in parameters and returns a value. 
 * Lambda expressions are similar to methods, but they do not need a name and they can be implemented right in the body of a method.
 * (parameter1, parameter2) -> expression
 * Expressions are limited. They have to immediately return a value, and they cannot contain variables, assignments or statements such as if or for. 
 * In order to do more complex operations, a code block can be used with curly braces. If the lambda expression needs to return a value, then the code block should have a return statement.
 * (parameter1, parameter2) -> { code block }
 */


/*
 * To use a lambda expression in a method, the method should have a parameter with a single-method interface as its type. 
 * Calling the interface's method will run the lambda expression:
 */
interface StringFunction { 
	  String run(String str);//use lambda expression, method should have a param inside a single-method interface
	}

public class LamdaExp {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
	    numbers.add(5);
	    numbers.add(9);
	    numbers.add(8);
	    numbers.add(1);
	    numbers.forEach( (n) -> { System.out.println(n); } );
	    
	    System.out.println("\nConsumer to store lamda expression");
	    Consumer<Integer> method = (n) -> { System.out.println(n); };//store lamda expression
	    numbers.forEach( method );
	    
	    StringFunction exclaim = (s) -> s + "!";
	    StringFunction ask = (s) -> s + "?";
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);
	}
	public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);//call interface method
	    System.out.println(result);
	  }

}