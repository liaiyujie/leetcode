package ljt.bupt.leetcode.tree;

import java.util.List;

public class BalancedBinaryTree_110 {

	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode root = TreeNode.createBinTree(nums);
		boolean res = isBalanced(root);
		System.out.println(res);

	}

	// 2.The second method is based on DFS.
	// Instead of calling depth() explicitly for each child node,
	// we return the height of the current node in DFS recursion.
	// When the sub tree of the current node (inclusive) is balanced,
	// the function dfsHeight() returns a non-negative value as the height.
	// Otherwise -1 is returned. According to the leftHeight and
	// rightHeight of the two children, the parent node could check
	// if the sub tree is balanced, and decides its return value.
	private static boolean isBalanced(TreeNode root) {
		return dfsHeight(root) != -1;
	}

	private static int dfsHeight(TreeNode root) {
		if (root == null)
			return 0;

		int leftHeight = dfsHeight(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = dfsHeight(root.right);
		if (rightHeight == -1)
			return -1;

		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}

	// 自己写的使用递归来完成
	// For the current node root, calling depth() for its left and
	// right children actually has to access all of its children,
	// thus the complexity is O(N). We do this for each node in the tree,
	// so the overall complexity of isBalanced will be O(N^2).
	// This is a top down approach.
	private static boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);

		}
	}

	private static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
	}

}
