package us.jianan;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.HashSet;

public class TestWordLadder2 {
	private Solution solution = new Solution(); 
	
	@Test
	public void testSingleCharWord() {
		String[] dict = {"a", "b", "c"};
		System.out.println(solution.findLadders("a", "c", arrayToHashSet(dict)));
	}
	
	private <T> HashSet<T> arrayToHashSet(T[] array) {
		HashSet<T> result = new HashSet<T>();
		for (T s: array) {
			result.add(s);
		}
		return result;
	}

}
