package JavaSessions;

/*
 * Create a thread: extends Thread and override run() method
 * Run thread:  create an instance of class then call its start() method
 */
public class ThreadMain extends Thread {
	public static int amount = 0;

	public static void main(String[] args) {
		ThreadMain thread = new ThreadMain();// create an instance of class then call its start() method
		thread.start(); // run the thread by calling override run() method
		
		// Wait for the thread to finish
		while (thread.isAlive()) {
			System.out.println("Waiting...");
		}
		
		System.out.println("\nThis code is outside of the thread");
		System.out.println(amount);
		amount++;
		System.out.println(amount);
	}

	public void run() {
		System.out.println("This code is running in a thread");
		amount++;
		System.out.println("run() " + amount);
	}

}
