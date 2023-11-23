package javaOOP;

abstract class Animal1{
	// Abstract method (does not have a body)
		public abstract void animalSound();

	// Regular method
		public void sleep() {
			System.out.println("Zzz");
		}
	}

class Pig1 extends Animal1 {
	public void animalSound() {
		// The body of animalSound() is provided here
		System.out.println("The pig says: wee wee");
	}
}

public class AbstractionTest {
	public static void main(String[] args) {
		Pig1 myPig = new Pig1(); // Create a Pig object
		myPig.animalSound();
		myPig.sleep();
	}
}
