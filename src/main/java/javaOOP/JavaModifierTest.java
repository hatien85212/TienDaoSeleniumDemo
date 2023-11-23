package javaOOP;

public class JavaModifierTest {
	public static void main(String[ ] args) {
	    JavaModifier.myStaticMethod(); // Call the static method
	    // myPublicMethod(); This would output an error

	    JavaModifier myObj = new JavaModifier(); // Create an object of JavaModifier
	    myObj.myPublicMethod(); // Call the public method
	  }
}
