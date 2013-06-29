package us.jianan;
/* problem:
Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:

All words have the same length.
All words contain only lowercase alphabetic characters.
*/

/* thoughts:
recursive, iterate all adjacent nodes of the start word
record visted and results list, if find shorter way, clear results list with the new method

pseudo code
===========
class WordLadder2
	@visited = List
	@dict = dictionary
	@start = start word
	@end = end word

	wordLadder
		wordLadderRecursive(@start, [[]])

	wordLadderRecursive(word)
		if word == @end
			return [[@end]]
		visited.push(word)
		results = list
		for adjacent_word of word.all_valid_adjacent_words
			if (adj in visited) continue
			for list in wordLadderRecursive(adj)
				results.add(list)
		visited.pop
		for list in results
			list.prepend(word)
		return results
*/

import java.util.Stack;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {
	class WordLadder2 {
		private Stack<String> visited;
		private String start, end;
		private HashSet<String> dict;
		public WordLadder2(String start, String end, HashSet<String> dict) {
			this.start = start;
			this.end = end;
			this.dict = dict;
			visited = new Stack<String>();
		}
		public ArrayList<ArrayList<String>> wordLadder() {
			ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
			int min = Integer.MAX_VALUE;
			for (ArrayList<String> list: wordLadderRecursive(start)) {
				if (list.size() < min)
					min = list.size();
			}
			for (ArrayList<String> list: wordLadderRecursive(start)) {
				if (list.size() == min) {
					results.add(list);
				}
			}
			return results;
		}
		public ArrayList<ArrayList<String>> wordLadderRecursive(String word) {
			if (word.equals(end)) {
				return initiateListOfList(word);
			}
			visited.push(word);
			ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
			for (String adjacent: allAdjacentWordsInDictionary(word)) {
				if (visited.contains(adjacent))
					continue;
				for (ArrayList<String> list: wordLadderRecursive(adjacent)) {
					results.add(list);
				}
			}
			visited.pop();
			for (ArrayList<String> list: results) {
				list.add(0, word);
			}
			return results;
		}
		private HashSet<String> allAdjacentWordsInDictionary(String word) {
			HashSet<String> results = new HashSet<String>();
			char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
			for (int i = 0; i < word.length(); i++) {
				for (char c: chars) {
					char[] arr = word.toCharArray();
					arr[i] = c;
					String newWord = new String(arr);
					if (dict.contains(newWord)) {
						results.add(newWord);
					}
				}
			}
			return results;
		}
		private ArrayList<ArrayList<String>> initiateListOfList(String word) {
			ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
			ArrayList<String> list = new ArrayList<String>();
			list.add(word);
			lists.add(list);
			return lists;
		}
	}
	
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
		WordLadder2 wordLadder2 = new WordLadder2(start, end, dict);
		return wordLadder2.wordLadder();
    }
}

/* test cases
Progress: 7/13 test cases passed.
input	output	expected	
"a", "c", ["a","b","c"]	[["a","b","c"],["a","c"]]	[["a","c"]]	
   
"hot", "dog", ["hot","dog"]	[]	[]	
   
"hot", "dog", ["hot","dog","dot"]	[["hot","dot","dog"]]	[["hot","dot","dog"]]	
   
"hot", "dot", ["hot","dot","dog"]	[["hot","dot"]]	[["hot","dot"]]	
   
"hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]	[["hot","tot","pot","dot","dog"],["hot","tot","dot","dog"],["hot","hog","cog","dog"],["hot","hog","dog"],["hot","hop","hog","cog","dog"],["hot","hop","hog","dog"],["hot","pot","tot","dot","dog"],["hot","pot","dot","dog"],["hot","dot","dog"]]	[["hot","dot","dog"],["hot","hog","dog"]]	
   
"hot", "dog", ["hot","dog","cog","pot","dot"]	[["hot","pot","dot","dog"],["hot","dot","dog"]]	[["hot","dot","dog"]]	
   
"hit", "cog", ["hot","cog","dot","dog","hit","lot","log"]	[["hit","hot","lot","log","cog"],["hit","hot","lot","log","dog","cog"],["hit","hot","lot","dot","dog","cog"],["hit","hot","lot","dot","dog","log","cog"],["hit","hot","dot","lot","log","cog"],["hit","hot","dot","lot","log","dog","cog"],["hit","hot","dot","dog","cog"],["hit","hot","dot","dog","log","cog"]]	[["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]	
   
"hit", "cog", ["hot","hit","cog","dot","dog"]	[["hit","hot","dot","dog","cog"]]	[["hit","hot","dot","dog","cog"]]	
   
"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]	[["red","rex","tex","tax"],["red","rex","tex","ted","tad","tax"],["red","ted","tex","tax"],["red","ted","tad","tax"]]	[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]	
   
"lost", "cost", ["most","fist","lost","cost","fish"]	[["lost","most","cost"],["lost","cost"]]	[["lost","cost"]]	
   
"lost", "miss", ["most","mist","miss","lost","fist","fish"]	[["lost","most","mist","miss"]]	[["lost","most","mist","miss"]]	
   
"leet", "code", ["lest","leet","lose","code","lode","robe","lost"]	[["leet","lest","lost","lose","lode","code"]]	[["leet","lest","lost","lose","lode","code"]]	
   
"talk", "tail", ["talk","tons","fall","tail","gale","hall","negs"]	[]	[]	
   
*/