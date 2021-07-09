package JavaSessions;

/*
 * Create a thread: implements Runnable interface and override run() method
 * Run thread:  create an instance of class then call its start() method
 * the thread can be run by passing an instance of the class to a Thread object's constructor
 * and then calling the thread's start() method
 */
public class ThreadRunnable implements Runnable{
	public static void main(String[] args) {
		ThreadRunnable obj = new ThreadRunnable();
	    Thread thread = new Thread(obj);
	    thread.start();
	    System.out.println("This code is outside of the thread");
	  }
	  public void run() {
	    System.out.println("This code is running in a thread");
	  }
}
