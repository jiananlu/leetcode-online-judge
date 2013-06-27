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
	class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	public void postOrderTraverseTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> nodes = new Stack<TreeNode>();
		Stack<Boolean> orders = new Stack<Boolean>(); // true: not enter left tree; false: from left tree
		nodes.push(root);
		orders.push(true);
		
		while(!nodes.isEmpty()) {
			TreeNode node = nodes.pop();
			boolean order = orders.pop();
			if (order == null) {
				continue;
			}
			if (node.left == null && node.right == null) {
				System.out.println("leaf!");
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
			}
			else {
				if (node.right != null) {
					nodes.push(node);
					orders.push(null);
					nodes.push(node.right);
					orders.push(true);
					continue;
				}
			} // of if-else
		} // of while
	} // of method
} // of class