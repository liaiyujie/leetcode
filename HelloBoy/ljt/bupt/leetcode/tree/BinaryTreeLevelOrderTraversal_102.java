package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<List<Integer>> res = levelOrder(root);
		for (List re : res) {
			System.out.println(re);
		}
	}
//	DFS-5ms - Increment level by one as we advance to next level.
//	when the level size is 0, we've reached to the end.
	private static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		// corner case
		if (root == null) {
			return result;
		}
		int maxLevel = 0;
		while (true) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			dfs(root, level, 0, maxLevel);
			if (level.size() == 0) {
				break;
			}
			result.add(level);
			maxLevel++;
		}
		return result;
	}
//  idea: starting from current level and stop at max level,
//	and add the node in current level to result
	private static void dfs(TreeNode root, ArrayList<Integer> level, int curtLevel, int maxLevel) {
		// stop when reach maxLevel
		if (root == null || curtLevel > maxLevel) {
			return;
		}
		// when only one level (root level)
		if (curtLevel == maxLevel) {
			level.add(root.val);
			return;
		}
		dfs(root.left, level, curtLevel + 1, maxLevel);
		dfs(root.right, level, curtLevel + 1, maxLevel);

	}

	// 和我的思想差不多，但是人家只用了一个队列，更加体现了思维的缜密
	// BFS- 3ms- for each node, first the node is visited then its child nodes
	// are put in a FIFO Queue.
	private static List<List<Integer>> levelOrder3(TreeNode root) {
		// first create an ArrayList to store integer arrays
		List<List<Integer>> result = new ArrayList<>();
		// corner case
		if (root == null) {
			return result;
		}
		// create a FIFO queue to store list of TreeNode
		Queue<TreeNode> queue = new LinkedList<TreeNode>();

		// add the root to queue
		queue.offer(root);
		while (!queue.isEmpty()) {
			// create a Integer ArrayList to store the nodes of current level
			ArrayList<Integer> level = new ArrayList<Integer>();
			int size = queue.size();
			// for each node in the current level, add the head to the ArrayList
			for (int i = 0; i < size; i++) {
				TreeNode head = queue.poll();
				level.add(head.val);
				if (head.left != null) {
					queue.offer(head.left);
				}
				if (head.right != null) {
					queue.offer(head.right);
				}
			}
			result.add(level); // add the nodes of current level to result
		}
		return result;
	}

	private static List<List<Integer>> levelOrder2(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		levelHelper(res, root, 0);
		return res;
	}

	private static void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
		if (root == null)
			return;
		if (height >= res.size()) {
			res.add(new LinkedList<Integer>());
		}
		res.get(height).add(root.val);
		levelHelper(res, root.left, height + 1);
		levelHelper(res, root.right, height + 1);

	}

	// 宽度优先遍历，准备两个数组，因为要记录每一层的节点，
	// 所以两个队列轮流使用，更换了一个队列，说明是下一层的节点
	private static List<List<Integer>> levelOrder1(TreeNode root) {// BFS
		if (root == null)
			return new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.add(root);
		int change = 1;
		while (!queue1.isEmpty() || !queue2.isEmpty()) {
			if (change % 2 == 1) {
				List<Integer> l = new ArrayList<>();
				int size = queue1.size();
				while (size-- > 0) {
					TreeNode t = queue1.poll();
					if (t.left != null)
						queue2.offer(t.left);
					if (t.right != null)
						queue2.offer(t.right);
					l.add(t.val);
				}
				res.add(l);
				change++;
			} else {
				List<Integer> l = new ArrayList<>();
				int size = queue2.size();
				while (size-- > 0) {
					TreeNode t = queue2.poll();
					if (t.left != null)
						queue1.offer(t.left);
					if (t.right != null)
						queue1.offer(t.right);
					l.add(t.val);
				}
				res.add(l);
				change++;
			}
		}
		return res;
	}

}
