package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumDepthofBinaryTree_104 {

	public static void main(String[] args) {

	}
	
//	This is the iterative version of finding the depth.
//	The recursive version is trivial, so expect the interviewer to ask for the iterative version.
//	I used two stacks for the dfs one and a queue for the level-order traversal one. Level order one is faster.

	public int maxDepth2(TreeNode root) {// BFS
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
	}

	public int maxDepth1(TreeNode root) {// DFS
		if (root == null) {
			return 0;
		}

		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int temp = value.pop();
			max = Math.max(temp, max);
			if (node.left != null) {
				stack.push(node.left);
				value.push(temp + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				value.push(temp + 1);
			}
		}
		return max;
	}

	private static int maxDepth(TreeNode root) {// iterative
		if (root == null)
			return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
}
