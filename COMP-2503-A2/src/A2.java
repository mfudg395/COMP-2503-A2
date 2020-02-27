import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
/**
 * COMP 2503 Winter 2020 Assignment 2
 * 
 * This program reads a text file and compiles a list of the words together with
 * how many each word appears.
 *
 * Words from a standard list of stop words are not included.
 * 
 * Updated Winter 2020
 * 
 * @author Maryam Elahi
 */
public class A2 {

	private SLL<Token> wordlist = new SLL<Token>();

	private String[] stopwords = { "a", "about", "all", "am", "an", "and", "any", "are", "as", "at", "be", "been",
			"but", "by", "can", "cannot", "could", "did", "do", "does", "else", "for", "from", "get", "got", "had",
			"has", "have", "he", "her", "hers", "him", "his", "how", "i", "if", "in", "into", "is", "it", "its", "like",
			"more", "me", "my", "no", "now", "not", "of", "on", "one", "or", "our", "out", "said", "say", "says", "she",
			"so", "some", "than", "that", "the", "their", "them", "then", "there", "these", "they", "this", "to", "too",
			"us", "upon", "was", "we", "were", "what", "with", "when", "where", "which", "while", "who", "whom", "why",
			"will", "you", "your" };

	private int totalwordcount = 0;

	private int stopwordcount = 0;

	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		A2 a2 = new A2();
		a2.run();
	}

	private void printResults() {
		System.out.println("Total Words: " + totalwordcount);
		System.out.println("Unique Words: " + wordlist.size());
		System.out.println("Stop Words: " + stopwordcount);
		System.out.println();
		System.out.println("10 Most Frequent");

		/*
		 * TODO: Use collection sort to sort the wordlist in descending frequency order.
		 * Then print the first 10.
		 */
		SLL<Token> desclist = new SLL<Token>(wordlist);
		

		System.out.println();
		System.out.println("10 Least Frequent");
		/*
		 * TODO: Use collection sort to sort the wordlist in ascending frequency order.
		 * Then print the first 10.
		 */

		System.out.println();
		System.out.println("All");
		/*
		 * TODO: Use collection sort to sort the wordlist by its natural ordering
		 * (alphabetical). Then print all the words.
		 */
		wordlist.printList();
	}

	/**
	 * Read the input file and process it. Input is on standard input and is read
	 * one word at a time -- separated by whitespace.
	 * 
	 * All non alphabetic characters are stripped out and words are all converted to
	 * lower case.
	 * 
	 * Any non-stopword word is stored in the list of words and the number of
	 * occurances is tracked.
	 */
	private void readFile() {
		while (input.hasNext()) {
			String s = input.next().trim().toLowerCase().replaceAll("[^a-z]", "");
			if (s.isEmpty()) {
				continue;
			}
			totalwordcount++;
			if (Arrays.asList(stopwords).contains(s)) {
				stopwordcount++;
				continue;
			}
			checkToken(s);

		}
	}

	/**
	 * Checks if a String already exists in a token in the wordlist.
	 * The SLL uses an Iterator to check through the entire list via
	 * a for-each loop.
	 * 
	 * The use of an iterator was an idea given by Nahuel Paladino and
	 * Pedro Janikian.
	 * 
	 * @param s String to check if it already exists in a token
	 */
	private void checkToken(String s) {
		for (Token t : wordlist) {
			if (t.getWord().equals(s)) {
				t.increment();
				return;
			}
		}
		wordlist.addInOrder(new Token(s));
	}

	/**
	 * Run the program. Read the file, then print the results.
	 */
	public void run() {
		readFile();
		printResults();
	}

}
