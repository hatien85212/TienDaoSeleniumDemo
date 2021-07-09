package JavaSessions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListMain {
	public static void main(String[] args) {
		ArrayList<String> cars = new ArrayList<String>();
		cars.add("Volvo");
		cars.add("BMW");
		cars.add("Ford");
		cars.add("Mazda");
		printList(cars);
		printListUseInterator(cars);
		sort(cars);
		method(cars);
	}
	
	public static void printList(ArrayList<String> list) {
		System.out.println("***** Array List items: ..." + list);
//	    for (int i = 0; i < cars.size(); i++) {
//	      System.out.println(cars.get(i));
//	    }
		for (String i : list) {
			System.out.println(i);
		}
	}
	public static void printListUseInterator(ArrayList<String> list) {
		System.out.println("\n***** Iterator use in Array List: ...");
		// Iterator which used in ArrayList, HashSet
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void sort(ArrayList<String> list) {
		System.out.println("\n***** Sort the list...");
		Collections.sort(list);  // Sort
		printList(list);
	}
	public static void method(ArrayList<String> list) {
		System.out.println("\n***** Array methods: add, set, get, remove...");
		list.add("NewValue");
		int size = list.size(); // size
		System.out.println("New value at the last " + list + " with size: " + size);
		list.set(size - 1, "UpdatedValue"); // set: update value on the last item
		System.out.println("Updated value at the last " + list.get(size-1));
		list.remove(size - 1); // remove: remove the last item
		System.out.println("Removed the last " + list);
	}
}
