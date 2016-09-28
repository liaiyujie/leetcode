package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SymmetricTree_101 {

	public static void main(String[] args) {
		int[] nums = { 1 };
		TreeNode root = TreeNode.createBinTree(nums);
		boolean res = isSymmetric(root);
		System.out.println(res);

	}

	private static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left, right;
		if (root.left != null) {
			if (root.right == null)
				return false;
			stack.push(root.left);
			stack.push(root.right);
		} else if (root.right != null) {
			return false;
		}

		while (!stack.empty()) {
			if (stack.size() % 2 != 0)
				return false;
			right = stack.pop();
			left = stack.pop();
			if (right.val != left.val)
				return false;

			if (left.left != null) {
				if (right.right == null)
					return false;
				stack.push(left.left);
				stack.push(right.right);
			} else if (right.right != null) {
				return false;
			}

			if (left.right != null) {
				if (right.left == null)
					return false;
				stack.push(left.right);
				stack.push(right.left);
			} else if (right.left != null) {
				return false;
			}
		}

		return true;
	}

	private static boolean isSymmetric2(TreeNode root) {// Recursive
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	private static boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
	}

	// 错误，以为用层序遍历出每一层，然后判断该层组成的数组是回文就行。有很多反例
	// 解决办法就是将树构造成一个完全的二叉树，节点的左右子树为空则添加一个虚拟节点在上面，不过这是很低级的做法
	private static boolean isSymmetric1(TreeNode root) {
		if (root == null || ((root.left == null) && (root.right == null)))
			return true;
		TreeNode empty = new TreeNode(Integer.MAX_VALUE);
		Queue<TreeNode> queue = new LinkedList<>();
		if (root.left != null)
			queue.add(root.left);
		else
			queue.add(empty);
		if (root.right != null)
			queue.add(root.right);
		else
			queue.add(empty);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int[] nums = new int[size];
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp == empty) {
					nums[i] = Integer.MAX_VALUE;
				} else {
					nums[i] = tmp.val;
					if (tmp.left != null)
						queue.add(tmp.left);
					else
						queue.add(empty);
					if (tmp.right != null)
						queue.add(tmp.right);
					else
						queue.add(empty);
				}
			}
			boolean res = arrayIsPalindrome(nums);
			if (res == false)
				return false;
		}
		return true;

	}

	// 该数组只有偶数个数字
	private static boolean arrayIsPalindrome(int[] nums) {
		int len = nums.length;
		for (int i = 0; i < len / 2; i++) {
			if (nums[i] != nums[len - i - 1])
				return false;
		}
		return true;
	}
}
