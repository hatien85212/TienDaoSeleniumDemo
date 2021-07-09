package JavaSessions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
	static Pattern pattern = null;
	static Matcher matcher = null;

	public static void main(String[] args) {
//		Pattern pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
//		Matcher matcher = pattern.matcher("Visit W3Schools!");
		boolean matchFound = isMatch("w3schools","Visit W3Schools!");
		if (matchFound) {
			System.out.println("Match found");
		} else {
			System.out.println("Match not found");
		}
		
		
	}

	public static boolean isMatch(String patternStr, String source) {
		pattern = Pattern.compile("w3schools", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher("Visit W3Schools!");
		return matcher.find();

	}
}
