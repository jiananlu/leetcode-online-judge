/* Example tree:
       5
     /   \
    3    2
   /\    /
  7  0  6 
    /
   0
traverse(root):
	stack.push(root)
	orders.push(true)
	while (!stack.isEmpty):
		node = stack.pop
		order = orders.pop
		if order == null:
			continue
		if node.left == null && node.right == null:
			print the stack
			continue
		if (order):
			if node.left != null:
				stack.push(node)
				orders.push(false)
				stack.push(node.left)
				orders.push(true)
				continue
		else:
			if node.right != null:
				stack.push(node)
				orders.push(null)
				stack.push(node.right)
				orders.push(true)
				continue
		
*/
package us.jianan;

import java.util.Stack;

public class PostOrderTraverseTree {
	static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(0);
		root.left.right.left = new TreeNode(0);
		root.right.left = new TreeNode(6);
		
		postOrderTraverseTree(root);
	}
	
	public static int postOrderTraverseTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int sum = 0;
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Boolean> orders = new Stack<Boolean>(); // true: not enter left tree; false: from left tree
		nodes.push(root);
		orders.push(true);
		
		while(!nodes.isEmpty()) {
			TreeNode node = nodes.pop();
			Boolean order = orders.pop();
			if (order == null) {
				continue;
			}
			if (node.left == null && node.right == null) {
				int tempSum = 0;
				for (TreeNode n: nodes) {
					tempSum += n.val;
					tempSum *= 10;
				}
				tempSum += node.val;
				sum += tempSum;
				continue;
			}
			if (order) {
				if (node.left != null) {
					nodes.push(node);
					orders.push(false);
					nodes.push(node.left);
					orders.push(true);
					continue;
				}
				else {
					nodes.push(node);
					orders.push(false);
					continue;
				}
			}
			else {
				if (node.right != null) {
					nodes.push(node);
					orders.push(null);
					nodes.push(node.right);
					orders.push(true);
					continue;
				}
				else {
					nodes.push(node);
					orders.push(null);
					continue;
				}
			} // of if-else
		} // of while
		return sum;
	} // of method
} // of class