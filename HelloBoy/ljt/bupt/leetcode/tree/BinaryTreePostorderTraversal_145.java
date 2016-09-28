package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreePostorderTraversal_145 {

	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<Integer> res = postorderTraversal(root);
		System.out.println(res);
	}

	private static List<Integer> postorderTraversal(TreeNode root) {
		TreeNode rNode = null;
		TreeNode current = root;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while (current != null || !stack.isEmpty()) {
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
			current = stack.pop();
			while (current != null && (current.right == null || current.right == rNode)) {
				list.add(current.val);
				rNode = current;
				if (stack.isEmpty()) {
					return list;
				}
				current = stack.pop();
			}
			stack.push(current);
			current = current.right;
		}
		return list;
	}

	private static List<Integer> postorderTraversal1(TreeNode root) {// 递归
		if (root == null)
			return list;
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		list.add(root.val);
		return list;
	}

}
