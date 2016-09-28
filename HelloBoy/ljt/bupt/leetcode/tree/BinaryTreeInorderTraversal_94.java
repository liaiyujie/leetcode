package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal_94 {
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<Integer> res = preorderNoRecursion(root);
		System.out.println(res);
	}
	
	private static List<Integer> preorderNoRecursion(TreeNode root) {// iteratively
		if (root == null)
			return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.add(root);
		TreeNode current = null;
		while(!stack.isEmpty()){
			current = stack.removeFirst();
			list.add(current.val);
			if (current.right != null)
				stack.addFirst(current.right);
			if (current.left != null)
				stack.addFirst(current.left);
		}
		return list;
	}
	private static List<Integer> inorderTraversal(TreeNode root) {// iteratively
		if (root == null)
			return list;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode current = root;
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.addFirst(current);
				current = current.left;
			}
			if (!stack.isEmpty()) {
				current = stack.removeFirst();
				list.add(current.val);
				current = current.right;
			}
		}
		return list;
	}

	private static List<Integer> inorderTraversal1(TreeNode root) {// Recursive
		if (root == null)
			return list;

		inorderTraversal(root.left);
		list.add(root.val);

		inorderTraversal(root.right);
		return list;
	}

}
