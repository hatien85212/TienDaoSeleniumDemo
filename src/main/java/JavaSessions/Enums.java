package JavaSessions;

/*
 * like a class, have attributes and methods. 
 * The only difference is that enum constants are public, static and final (unchangeable - cannot be overridden).
 * An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces)
 */
enum Level {
	LOW, MEDIUM, HIGH
}

public class Enums {
	public static void main(String[] args) {
		Level myVar = Level.MEDIUM;

		switch (myVar) {
		case LOW:
			System.out.println("Low level");
			break;
		case MEDIUM:
			System.out.println("Medium level");
			break;
		case HIGH:
			System.out.println("High level");
			break;
		}

		System.out.println("\nList all level enums:");
		for (Level level : Level.values()) {
			System.out.println(level);
		}
	}
}
