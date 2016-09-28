package ljt.bupt.leetcode.tree;

import java.util.LinkedList;
import java.util.Stack;

public class PathSum_112 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8 };
		TreeNode root = TreeNode.createBinTree(nums);
		int sum = 1;
		boolean res = hasPathSum3(root, sum);
		System.out.println(res);
	}

	private static boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> sums = new Stack<Integer>();

		stack.push(root);
		sums.push(sum);
		while (!stack.isEmpty() && (root != null)) {
			int value = sums.pop();
			TreeNode top = stack.pop();

			if (top.left == null && top.right == null && top.val == value) {
				return true;
			}
			if (top.right != null) {
				stack.push(top.right);
				sums.push(value - top.val);
			}
			if (top.left != null) {
				stack.push(top.left);
				sums.push(value - top.val);
			}

		}
		return false;
	}

	// the idea is preorder traverse , instead of using recursive call, I am
	// using a stack.
	// the only problem is that I changed TreeNode value
	private static boolean hasPathSum2(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty() && root != null) {
			TreeNode cur = stack.pop();
			if (cur.left == null && cur.right == null) {
				if (cur.val == sum)
					return true;
			}
			if (cur.right != null) {
				cur.right.val = cur.val + cur.right.val;
				stack.push(cur.right);
			}
			if (cur.left != null) {
				cur.left.val = cur.val + cur.left.val;
				stack.push(cur.left);
			}
		}
		return false;
	}

	private static boolean hasPathSum3(TreeNode root, int sum) {// DFS
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> value = new LinkedList<>();
		if (root == null)
			return false;
		stack.addFirst(root);
		value.addFirst(root.val);
		while (!stack.isEmpty()) {
			TreeNode tmp = stack.removeFirst();
			int tmpVal = value.removeFirst();
			if (tmp.right != null) {
				stack.addFirst(tmp.right);
				value.addFirst(tmpVal + tmp.right.val);
			}
			if (tmp.left != null) {
				stack.addFirst(tmp.left);
				value.addFirst(tmpVal + tmp.left.val);
			}
			if (tmp.right == null && tmp.left == null) {
				if (tmpVal == sum)
					return true;
			}
		}
		return false;
	}

	public boolean hasPathSum11(TreeNode root, int sum) {// 别人写的递归，也改变了节点的值
//		if (root == null) return false;
//	    sum = sum - root.val;
//	    if (root.left == null && root.right == null && sum == 0) return true;
//	    return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
		
		if (root == null)
			return false;

		if (root.left == null && root.right == null && root.val == sum)
			return true;

		boolean ans1 = false, ans2 = false;
		if (!(root.left == null)) {
			root.left.val += root.val;
			ans1 = hasPathSum(root.left, sum);
		}

		if (!(root.right == null)) {
			root.right.val += root.val;
			ans2 = hasPathSum(root.right, sum);
		}

		return ans1 || ans2;

	}
//  看了别人的答案，为什么我写不出来呢？？？
	private static boolean hasPathSum1(TreeNode root, int sum) {// 打算用递归写，但发现难度好大，因为结果只要出现一条为真就行
		if (root != null) {
			int value = 0;
			return helper(root, sum, value);
		}
		return false;
	}

	private static boolean helper(TreeNode root, int sum, int value) {
		if (root.left == null && root.right == null) {
			value += root.val;
			if (value == sum)
				return true;
		} else if (root.left != null) {
			value += root.val;
			helper(root.left, sum, value);
		} else if (root.right != null && root.left == null) {
			value += root.val;
			helper(root.right, sum, value);
		} else {
			helper(root.right, sum, value);
		}
		// if (root.right != null&&root.left != null) {
		// helper(root.right, sum, value);
		// }
		return false;
	}

}
