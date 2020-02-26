import java.util.Comparator;

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
}