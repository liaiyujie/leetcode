package ljt.bupt.leetcode.tree;

import java.util.LinkedList;

public class SumofLeftLeaves_404 {

	public static void main(String[] args) {
		int[] nums = { 3, 20, 9, 15, 7 };
		TreeNode root = TreeNode.createBinTree(nums);
		int res = sumOfLeftLeaves1(root);
		System.out.println(res);

	}

	private static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null && root.left.left == null && root.left.right == null)
			return root.left.val + sumOfLeftLeaves(root.right);
		return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
	}

	private static int sumOfLeftLeaves1(TreeNode root) {// 有一个测试样例过不去，就是root.left==null&&root.right==null这个情况得返回0
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			return root.val;
		} else if (root.left != null && root.left.left == null && root.left.right == null
				&& (root.right == null || (root.right.left == null && root.right.right == null))) {
			return root.left.val;
		}
		if (root.right != null && root.right.left == null && root.right.right == null) {
			return sumOfLeftLeaves(root.left);
		} else {
			return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
		}

	}

}
