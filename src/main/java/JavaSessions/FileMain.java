package JavaSessions;

import java.io.File; // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors
import java.util.Scanner;

public class FileMain {
	public static void main(String[] args) {
		String folder = System.getProperty("user.dir") + "/src/test/resources/";
		String fileName = folder + "filename.txt";

		String[] content = { "Files in Java might be tricky, but it is fun enough!", "\nText in new line" };

		System.out.println("***** fileName..." + fileName);
		createFile(fileName);
		writeToFile(fileName, content);
		readFile(fileName);
//		deleteFile(fileName);
	}

	public static void createFile(String fileName) {
		System.out.println("\n***** createFile...");
		try {
			File myObj = new File(fileName);
			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String fileName, String[] content) {
		System.out.println("\n***** writeToFile...");
		try {
			FileWriter myWriter = new FileWriter(fileName); // append default = false
			for (String string : content) {
				myWriter.write(string);
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void writeToFile(String fileName) {
		System.out.println("\n***** writeToFile...");
		try {
			FileWriter myWriter = new FileWriter(fileName); // append default = false
//			FileWriter myWriter = new FileWriter(fileName, true);// append text
			myWriter.write("Files in Java might be tricky, but it is fun enough!");
			myWriter.write("\nText in new line");
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void readFile(String fileName) {
		System.out.println("\n***** readFile...");
		try {
			File myObj = new File(fileName);
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	public static void deleteFile(String fileName) {
		System.out.println("\n***** deleteFile...");
		File myObj = new File(fileName);
		if (myObj.delete()) {
			System.out.println("Deleted the file: " + myObj.getName());
		} else {
			System.out.println("Failed to delete the file.");
		}
	}
}
