import java.util.Comparator;

/** 
 * COMP 2503 Winter 2020 Assignment 2 Token Class
 * 
 * @author Matthew Fudge
*/

public class Token implements Comparable<Token> {

	private String word;
	private int counter;
	
	public Token(String word) {
		this.word = word;
		counter = 1;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getCounter() {
		return counter;
	}
	
	/**
	 * Adds one to the word frequency counter.
	 */
	public void increment(){
		counter++;
	}
	
	/**
	 * Returns a String representation of a token in
	 * the format of "word : frequency counter".
	 * 
	 * @return String representation of token
	 */
	public String toString(){
		return word + " : " + counter;
	}
	
	/**
	 * Sorts tokens by their natural ordering (the
	 * alphabetical order of their words).
	 * 
	 * @param the token to compare to
	 * @return integer determining which token is greater
	 */
	@Override
	public int compareTo(Token other) {
		return this.word.compareTo(other.getWord());
	}
	
	/**
	 * Checks if two tokens are equal. Tokens are considered
	 * equal if they have the same word.
	 * 
	 * @param a generic object to check
	 * @return true if words are the same, false is otherwise
	 */
	@Override
	public boolean equals(Object other) {
		if (other == this)
			return true;
		if (other == null)
			return false;
		Token checkToken = (Token) other;
		return this.word.equals(checkToken.getWord());
	}
	
	public class CompCountAsc implements Comparator<Token> {

		/**
		 * Sorts tokens based on ascending order
		 * of their counter frequency.
		 * 
		 * @param t1 the first token to compare
		 * @param t2 the second token to compare
		 * @return integer determining which token is greater
		 */
		@Override
		public int compare(Token t1, Token t2) {
			if (t1.getCounter() == t2.getCounter()) {
				return t1.compareTo(t2);
			}
			return t2.getCounter() - t1.getCounter();
		}
	};
	
	public class CompCountDesc implements Comparator<Token> {

		/**
		 * Sorts tokens based on descending order
		 * of their counter frequency.
		 * 
		 * @param t1 the first token to compare
		 * @param t2 the second token to compare
		 * @return integer determining which token is less
		 */
		@Override
		public int compare(Token t1, Token t2) {
			if (t1.getCounter() == t2.getCounter()) {
				return t1.compareTo(t2);
			}
			return t1.getCounter() - t2.getCounter();
		}
	}
}