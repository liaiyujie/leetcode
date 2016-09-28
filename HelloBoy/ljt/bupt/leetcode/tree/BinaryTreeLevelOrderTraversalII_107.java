package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII_107 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<List<Integer>> res = levelOrderBottom(root);
		for (List re : res) {
			System.out.println(re);
		}

	}

	private static List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> res = new LinkedList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				l.add(tmp.val);
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			res.addFirst(l);
		}
		return res;
	}

}
