package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode root = TreeNode.createBinTree(nums);
		TreeNode res = invertTree(root);
		System.out.println(TreeNode.levelPrintTree(res));
	}

	private static TreeNode invertTree(TreeNode root) {// iterative
		if (root == null)
			return root;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}
		return root;
	}

	private static TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		return root;
	}

	private static TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		else {
			TreeNode tmp = root.right;
			root.right = root.left;
			root.left = tmp;
		}
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

}
