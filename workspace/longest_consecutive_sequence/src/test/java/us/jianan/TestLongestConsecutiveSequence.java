package us.jianan;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLongestConsecutiveSequence {
	final private Solution solution = new Solution();
	
	@Test
	public void testThreeElements() {
		int[] array = {-1, 1, 0}; 
		assertEquals(3, solution.findLongestConsequence(array));
	}
	
	@Test
	public void testWhat() {
		int[] array = {100,4,200,1,3,2};
		assertEquals(4, solution.findLongestConsequence(array));
	}

}
