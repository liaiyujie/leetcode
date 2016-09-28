package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthofBinaryTree_111 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createBinTree(nums);
		int res = minDepth(root);
		System.out.println(res);

	}

	private static int minDepth(TreeNode root) {// 递归
		// if (root == null)
		// return 0;
		// if (root.left == null)
		// return minDepth(root.right) + 1;
		// if (root.right == null)
		// return minDepth(root.left) + 1;
		// return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
		if (root == null) {
			return 0;
		} else if (root.right == null && root.left == null) {
			return 1;
		} else if (root.left == null) {
			return minDepth(root.right) + 1;
		} else if (root.right == null) {
			return minDepth(root.left) + 1;
		} else {
			int l = minDepth(root.left);
			int r = minDepth(root.right);

			return l > r ? r + 1 : l + 1;
		}

	}

	// 按照层序遍历（BFS）遍历到的第一个叶子节点所到达的长度即为最小路径
	private static int minDepth1(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return 0;
		queue.offer(root);
		int count = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left == null && tmp.right == null) {
					return count;
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			count++;
		}
		return 0;
	}
}
