package JavaSessions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStream {
	public static void main(String args[]) {

		String fileName = "lines.txt";
		String[] content = { "line1", "\nline2", "\nline3", "\nline3.1", "\nline3.2", "\nline4" };
		FileMain.createFile(fileName);
		FileMain.writeToFile(fileName, content);

		// read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			stream //
					.onClose(() -> System.out.println("Done!")) //
					.filter(s -> s.startsWith("line3")) //
					.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
//		FileMain.deleteFile(fileName);
	}
}
