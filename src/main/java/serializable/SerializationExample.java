package serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationExample {
	public static void main(String[] args) {
		// Create Student object
		Student student = new Student();
		student.setName("Khanh");
		student.setAge(30);
		// Use FileOutputStream to save the Student object into a file
		String folder = System.getProperty("user.dir") + "/src/test/resources/";
		String fileName = folder + "student.txt";
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(student);
			System.err.println(student);
//			Student student2 = 
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
}