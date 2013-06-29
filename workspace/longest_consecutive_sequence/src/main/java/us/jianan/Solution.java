package us.jianan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	class Range {
		private int start, end;
		public Range(int start, int end) {this.start = start; this.end = end;}
		public int includes(int number) {
			// [2,3,4,5], start=2, end=5
			if (number < start - 1 || number > end + 1) { return 0 ;} // number= 0 or 7 or other outside #
			if (number == start - 1 || number == end + 1) { return 1; } // number = 1
			if (number >= start && number <= end) { return 2; } // number =2, 3, 4, 5
			throw new RuntimeException();
		}
		public int lengthOfRange() {
			return end - start + 1;
		}
		public void merge(Range range) {
			if (range.end == start - 1) {
				start = range.start;
				return;
			}
			if (range.start == end + 1) {
				end = range.end;
				return;
			}
			throw new RuntimeException();
		}
		public String toString() {
			return String.format("(%s,%s)", start, end);
		}
		public boolean equals(Object obj) {
			if (obj == this)
				return true;
			if (obj == null)
				return false;
			if (obj.getClass() != getClass())
				return false;
			if (((Range) obj).start != start)
				return false;
			if (((Range) obj).end != end)
				return false;
			return true;
		}
	}
	
	public int longestConsecutive(int[] num) {
		if (num.length == 0)
			return 0;
        int longest = 1;
		List<Range> ranges = new LinkedList<Range>();
		ranges.add(new Range(num[0], num[0]));
		
		for (int i: num) {
			List<Range> merges = new LinkedList<Range>();
			boolean adds = true;
			for (Range range: ranges) {
				int r = range.includes(i);
				if (r == 1) {
					adds = false;
					merges.add(range);
				}
				else if (r == 2) {
					adds = false;
					break;
				}
			}
			if (merges.size() > 0) {
				Range middle = new Range(i, i);
				for (Range range: merges) {
					middle.merge(range);
					ranges.remove(range);
				}
				ranges.add(middle);
				if (longest < middle.lengthOfRange()) {
					longest = middle.lengthOfRange();
				}
			}
			if (adds) {
				ranges.add(new Range(i, i));
			}
		}
		return longest;
    }
	
	// solution from:
	// http://discuss.leetcode.com/questions/1070/longest-consecutive-sequence
	public int findLongestConsequence(int[] a) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int max = 1;
	    for (int i : a) {
	        if (map.containsKey(i)) continue;
	        map.put(i, 1);
	        if (map.containsKey(i - 1)) {
	            max = Math.max(max, merge(map, i-1, i));
	        }
	        if (map.containsKey(i + 1)) {
	            max = Math.max(max, merge(map, i, i+1));
	        }
	    }
	    return max;
	}

	private int merge(HashMap<Integer, Integer> map, int left, int right) {
	    int upper = right + map.get(right) - 1;
	    int lower = left - map.get(left) + 1;
	    int len = upper - lower + 1;
	    map.put(upper, len);
	    map.put(lower, len);
	    return len;
	}

    
}