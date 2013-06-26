// small passed; large not passed

/* Problem:
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        return partition(s, 0);
    }
    
    public ArrayList<ArrayList<String>> partition(String s, int start) {
        if (start == s.length() - 1) {
            // if only one char left, 0 cut needed
			ArrayList<String> list = new ArrayList<String>();
			list.add(s.substring(s.length() - 1, s.length()));
			ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
			lists.add(list);
			return lists;
        }
		
		ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		
		if (start < s.length() && isPalindrome(s, start, s.length() - 1)) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(s.substring(start, s.length()));
			lists.add(list);
		}
        
        for (int i = start; i < s.length(); i++) {
            // loop through all possible cuts
            if (isPalindrome(s, start, i)) {
                ArrayList<ArrayList<String>> restLists = partition(s, i + 1);
				for (ArrayList<String> list : restLists) {
					list.add(s.substring(start, i + 1));
					lists.add(list);
				}
            }
        }
		
		return lists;
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true; // it's always palindrome when single char string
        }
        
        int step = (end - start + 1) / 2;
        
        for (int i = 0; i < step; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        
        return true;
    }
}

/*
Progress: 4/10 test cases passed.
  NOTE: the order of element in the array are different which causes the online judge to fail
		but the results are correct regardless the order of elements in the array
input	output	expected	
"a"	[["a"]]	[["a"]]	
   
"ab"	[["b","a"]]	[["a","b"]]	
   
"bb"	[["bb"],["b","b"]]	[["b","b"],["bb"]]	
   
"cdd"	[["dd","c"],["d","d","c"]]	[["c","d","d"],["c","dd"]]	
   
"dde"	[["e","d","d"],["e","dd"]]	[["d","d","e"],["dd","e"]]	
   
"efe"	[["efe"],["e","f","e"]]	[["e","f","e"],["efe"]]	
   
"fff"	[["fff"],["ff","f"],["f","f","f"],["f","ff"]]	[["f","f","f"],["f","ff"],["ff","f"],["fff"]]	
   
"abbab"	[["bab","b","a"],["b","a","b","b","a"],["b","a","bb","a"],["b","abba"]]	[["a","b","b","a","b"],["a","b","bab"],["a","bb","a","b"],["abba","b"]]	
   
"leet"	[["t","e","e","l"],["t","ee","l"]]	[["l","e","e","t"],["l","ee","t"]]	
   
"coder"	[["r","e","d","o","c"]]	[["c","o","d","e","r"]]	
    
*/