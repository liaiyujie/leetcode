package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<List<Integer>> res = zigzagLevelOrder(root);
		for (List re : res) {
			System.out.println(re);
		}
	}

	// 试试能不能直接添加进队列为Z数据
	// [1]
	// [2, 3]
	// [5, 4, 7, 6]
	/*private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		helper(root,res,queue);
		return res;
	}

	private static void helper(TreeNode root, List<List<Integer>> res,Queue<TreeNode> queue) {
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> q = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (count % 2 == 0) {// 奇数层，顺着添加
					if (tmp.left != null) {
						queue.offer(tmp.left);
					}
					if (tmp.right != null) {
						queue.offer(tmp.right);
					}
				} else {
					if (tmp.right != null) {
						queue.offer(tmp.right);
					}
					if (tmp.left != null) {
						queue.offer(tmp.left);
					}
				}
				q.add(tmp.val);
			}
			res.add(q);
		}
		
	}*/

	// BFS 使用队列和栈来保存数据
	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> q = new LinkedList<>();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (count % 2 == 0) {// 奇数层，顺着添加
					q.offer(tmp.val);
				} else {
					q.addFirst(tmp.val);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
			}
			res.add(q);
			count++;
		}
		return res;
	}

}
