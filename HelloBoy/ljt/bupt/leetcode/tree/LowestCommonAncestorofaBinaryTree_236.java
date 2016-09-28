package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofaBinaryTree_236 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createBinTree(nums);
		TreeNode p = new TreeNode(8);
		TreeNode q = new TreeNode(5);
		TreeNode res = lowestCommonAncestor1(root, p, q);
		System.out.println(res.val);

	}

	private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		TreeNode left = lowestCommonAncestor1(root.left, p, q);
		TreeNode right = lowestCommonAncestor1(root.right, p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}

	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == false
				&& CheckIsFather(root.right, p, q) == false) {
			return root;
		} else if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == true
				&& CheckIsFather(root.right, p, q) == false) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == false
				&& CheckIsFather(root.right, p, q) == true) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return null;
		}
	}

	private static boolean CheckIsFather(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return false;
		boolean flag1 = false;
		boolean flag2 = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int t = 0;
		while (!queue.isEmpty()) {
			// int size = queue.size();

			TreeNode tmp = queue.poll();
			if (tmp.left != null) {
				queue.offer(tmp.left);
			}
			if (tmp.right != null) {
				queue.offer(tmp.right);
			}

			if (tmp.val == p.val || tmp.val == q.val) {
				if (p.val != q.val) {
					if (tmp.val == p.val)
						flag1 = true;
					if (tmp.val == q.val)
						flag2 = true;
				} else {
					t++;
				}
			}

		}
		return (flag1 && flag2) || t == 2;
	}

}
