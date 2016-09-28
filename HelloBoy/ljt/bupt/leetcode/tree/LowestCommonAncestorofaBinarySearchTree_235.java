package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofaBinarySearchTree_235 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createBinTree(nums);
		TreeNode p = new TreeNode(8);
		TreeNode q = new TreeNode(5);
		TreeNode res = lowestCommonAncestor(root, p, q);
		System.out.println(res.val);

	}

	// 利用了BST树的特性
	private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val == p.val || root.val == q.val)
			return root;
		if ((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)) {
			return root;
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else {
			return null;
		}
	}

	// 没有借用BST树的特性。适合任意一种树，但是有BUG
	private static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
		if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == false
				&& CheckIsFather(root.right, p, q) == false) {
			return root;
		} else if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == true
				&& CheckIsFather(root.right, p, q) == false) {
			return lowestCommonAncestor1(root.left, p, q);
		} else if (CheckIsFather(root, p, q) == true && CheckIsFather(root.left, p, q) == false
				&& CheckIsFather(root.right, p, q) == true) {
			return lowestCommonAncestor1(root.right, p, q);
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
		int t = 0;// 防止有两个节点的值相等
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
