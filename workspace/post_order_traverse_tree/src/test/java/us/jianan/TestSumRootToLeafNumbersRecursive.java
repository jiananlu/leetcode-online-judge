package us.jianan;

import static org.junit.Assert.*;

import org.junit.Test;

import us.jianan.PostOrderTraverseTree.TreeNode;

public class TestSumRootToLeafNumbersRecursive {
	
	@Test
	public void testSimpleTwoLevelFullTree() {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		assertEquals(4, PostOrderTraverseTree.postOrderTraverseTree(root));
	}
	
	@Test
	public void testSimpleTwoLevelTreeWithOnlyRightLeaf() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(5);
		assertEquals(15, PostOrderTraverseTree.postOrderTraverseTree(root));
	}

	@Test
	public void testFourLevelTreeWithTwoConsequentZeros() {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(0);
		root.left.right.left = new TreeNode(0);
		root.right.left = new TreeNode(6);
		assertEquals(6363, PostOrderTraverseTree.postOrderTraverseTree(root));
	}

}
