package JavaSessions;

/*
 * Exception types available in Java: ArithmeticException, FileNotFoundException, ArrayIndexOutOfBoundsException, SecurityException
 * How to use: try, catch, final
 * And throw a custom exception
 */
public class ExceptionMain {
	public static void main(String[] args) {
		try {
			int[] myNumbers = { 1, 2, 3 };
			System.out.println(myNumbers[10]);
		} catch (Exception e) {
			System.out.println("Something went wrong.");
		} finally {
			System.out.println("The 'try catch' is finished."); // always execute regardless the result
		}
		
		checkAge(20);
		checkAge(15); // Set age to 15 (which is below 18...) which will throw error

	}
	
	static void checkAge(int age) {
	    if (age < 18) {
	      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
	    }
	    else {
	      System.out.println("Access granted - You are old enough!");
	    }
	  }
}
