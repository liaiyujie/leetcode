package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreorderTraversal_144 {

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
		while (!stack.isEmpty()) {
			current = stack.removeFirst();
			list.add(current.val);
			if (current.right != null)
				stack.addFirst(current.right);
			if (current.left != null)
				stack.addFirst(current.left);
		}
		return list;
	}

}
