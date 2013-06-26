public class Solution {
    public int minCut(String s) {
        return minCut(s, 0);
    }
    
    public int minCut(String s, int start) {
        if (start == s.length() - 1) {
            // if only one char left, 0 cut needed
            return 0;
        }
        if (isPalindrome(s, start, s.length() - 1)) {
            // if this is a palindrome as whole, 0 cut needed
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i = start; i < s.length(); i++) {
            // loop through all possible cuts
            if (isPalindrome(s, start, i)) {
                int restMin = minCut(s, i + 1);
                if (restMin < min) {
                    min = restMin;
                }
            }
        }
        return min + 1;
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

/* Test Cases
input	output	expected	
"a"	0	0	
   
"ab"	1	1	
   
"bb"	0	0	
   
"cdd"	1	1	
   
"dde"	1	1	
   
"efe"	0	0	
   
"fff"	0	0	
   
"abbab"	1	1	
   
"leet"	2	2	
   
"coder"	4	4	
   
"abcccb"	1	1	
   
"cabababcbc"	3	3	
   
*/