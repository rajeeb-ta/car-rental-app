import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestStringApp {
	
	static String longestWord(String[] sentence) {
		String longestSentence = "";
		for (int i=0; i< sentence.length; i++) {
			if(longestSentence.length() < sentence[i].length()) {
				longestSentence = sentence[i];
			}
		}
		return longestSentence;
	}
	
	public static void main(String[] args) throws IOException {
		int MAX_WORDS = 10;
		String[] sentence = new String[MAX_WORDS];
		
		//For reading input from console
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i< MAX_WORDS ; i++) {
			System.out.println("Enter word " + (i+1));
			sentence[i] = reader.readLine();
		}
		System.out.println("Longest Word is :" + longestWord(sentence));
	}
}
