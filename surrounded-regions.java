// small passed; large not passed
/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region .

For example,

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

public class Solution {
    class Node {
    	private int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int getX() { return x; }
		public int getY() { return y; }
		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		
		public boolean equals(Object obj) {
			if (obj == this) { return true; }
			if (obj == null) { return false; }
			if (obj.getClass() != getClass()) { return false; }
			if (((Node) obj).getX() != x) { return false; }
			if (((Node) obj).getY() != y) { return false; }
			return true;
		}
	}
	
    public void solve(char[][] board) {
		int length = board.length;
		
		// temporary board, true for 'O', false for 'X' (init state)
        boolean[][] tempBoard = new boolean [length][length];
		
		// queue to hold all nodes to be kept in final board
		Queue<Node> queue = new LinkedList<Node>();
		
		// store the initial 'O's at the edge
		for (int i = 0; i < length; i++) {
			if (board[0][i] == 'O') {
				Node node = new Node(0, i);
				if (!queue.contains(node)) {
					queue.add(node);
				}
			}
			if (board[i][0] == 'O') {
				Node node = new Node(i, 0);
				if (!queue.contains(node)) {
					queue.add(node);
				}
			}
			if (board[length - 1][i] == 'O') {
				Node node = new Node(length - 1, i);
				if (!queue.contains(node)) {
					queue.add(node);
				}
			}
			if (board[i][length - 1] == 'O') {
				Node node = new Node(i, length - 1);
				if (!queue.contains(node)) {
					queue.add(node);
				}
			}
		}
		
		while (!queue.isEmpty()) {
			Node center = queue.remove();
			int x = center.getX(), y = center.getY();
			
			// mark this as 'O' in temporary board
			tempBoard[x][y] = true;
				
			// north node
			if (x > 0 && board[x - 1][y] == 'O') {
				Node node = new Node(x - 1, y);
				if (!queue.contains(node) && !tempBoard[x - 1][y]) {
					queue.add(node);
				}
			}
			
			// south node
			if (x < length - 1 && board[x + 1][y] == 'O') {
				Node node = new Node(x + 1, y);
				if (!queue.contains(node) && !tempBoard[x + 1][y]) {
					queue.add(node);
				}
			}
			
			// west node
			if (y > 0 && board[x][y - 1] == 'O') {
				Node node = new Node(x, y - 1);
				if (!queue.contains(node) && !tempBoard[x][y - 1]) {
					queue.add(node);
				}
			}
			
			// east node
			if (y < length - 1 && board[x][y + 1] == 'O') {
				Node node = new Node(x, y + 1);
				if (!queue.contains(node) && !tempBoard[x][y + 1]) {
					queue.add(node);
				}
			}
		}
		
		// reset the input board
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				board[x][y] = 'X';
			}
		}

		// change the input board based on temporary board result
		for (int x = 0; x < length; x++) {
			for (int y = 0; y < length; y++) {
				if (tempBoard[x][y]) {
					board[x][y] = 'O';
				}
			}
		}
    }
}

/*
Progress: 16/16 test cases passed.
input	output	expected	
[]	[]	[]	
   
["X"]	["X"]	["X"]	
   
["O"]	["O"]	["O"]	
   
["OO","OO"]	["OO","OO"]	["OO","OO"]	
   
["XO","OX"]	["XO","OX"]	["XO","OX"]	
   
["XXX","XOX","XXX"]	["XXX","XXX","XXX"]	["XXX","XXX","XXX"]	
   
["XXX","XXX","XXX"]	["XXX","XXX","XXX"]	["XXX","XXX","XXX"]	
   
["OOO","OOO","OOO"]	["OOO","OOO","OOO"]	["OOO","OOO","OOO"]	
   
["OOO","OXO","OOO"]	["OOO","OXO","OOO"]	["OOO","OXO","OOO"]	
   
["XOX","XOX","XOX"]	["XOX","XOX","XOX"]	["XOX","XOX","XOX"]	
   
["XOX","OXO","XOX"]	["XOX","OXO","XOX"]	["XOX","OXO","XOX"]	
   
["OXO","XOX","OXO"]	["OXO","XXX","OXO"]	["OXO","XXX","OXO"]	
   
["XOXX","OXOX","XOXO","OXOX"]	["XOXX","OXXX","XXXO","OXOX"]	["XOXX","OXXX","XXXO","OXOX"]	
   
["OXXOX","XOOXO","XOXOX","OXOOO","XXOXO"]	["OXXOX","XXXXO","XXXOX","OXOOO","XXOXO"]	["OXXOX","XXXXO","XXXOX","OXOOO","XXOXO"]	
   
["XXXXX","XOOOX","XXOOX","XXXOX","XOXXX"]	["XXXXX","XXXXX","XXXXX","XXXXX","XOXXX"]	["XXXXX","XXXXX","XXXXX","XXXXX","XOXXX"]	
   
["OOOOOO","OXXXXO","OXOOXO","OXOOXO","OXXXXO","OOOOOO"]	["OOOOOO","OXXXXO","OXXXXO","OXXXXO","OXXXXO","OOOOOO"]	["OOOOOO","OXXXXO","OXXXXO","OXXXXO","OXXXXO","OOOOOO"]	
   

*/