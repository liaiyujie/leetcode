package ljt.bupt.leetcode.tree;

import java.util.Stack;

public class SameTree_100 {

	public static void main(String[] args) {
		int[] nums1 = { 4, 2, 7, 1, 3, 6, 9 };
		int[] nums2 = { 4, 2, 7, 1, 3, 6, 9 };
		TreeNode p = TreeNode.createBinTree(nums1);
		TreeNode q = TreeNode.createBinTree(nums2);
		boolean res = isSameTree(p, q);
		System.out.println(res);
	}

	private static boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> stack_p = new Stack<>();
		Stack<TreeNode> stack_q = new Stack<>();
		if (p != null)
			stack_p.push(p);
		if (q != null)
			stack_q.push(q);
		while (!stack_p.isEmpty() && !stack_q.isEmpty()) {
			TreeNode pn = stack_p.pop();
			TreeNode qn = stack_q.pop();
			if (pn.val != qn.val)
				return false;
			if (pn.right != null)
				stack_p.push(pn.right);
			if (qn.right != null)
				stack_q.push(qn.right);
			if (stack_p.size() != stack_q.size())
				return false;
			if (pn.left != null)
				stack_p.push(pn.left);
			if (qn.left != null)
				stack_q.push(qn.left);
			if (stack_p.size() != stack_q.size())
				return false;
		}
		return stack_p.size() == stack_q.size();
	}

	private static boolean isSameTree2(TreeNode p, TreeNode q) {// DFS
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (p != null) {
			stack.push(p);
		}
		if (q != null) {
			stack.push(q);
		}

		while (!stack.isEmpty() && stack.size() % 2 == 0) {
			TreeNode pn = stack.pop();
			TreeNode qn = stack.pop();
			if (pn.val != qn.val)
				return false;
			if (pn.right != null)
				stack.push(pn.right);
			if (qn.right != null)
				stack.push(qn.right);
			if (stack.size() % 2 != 0)
				return false;
			if (pn.left != null)
				stack.push(pn.left);
			if (qn.left != null)
				stack.push(qn.left);
			if (stack.size() % 2 != 0)
				return false;
		}
		if (stack.size() % 2 != 0) {
			return false;
		} else {
			return true;
		}
	}

	private static boolean isSameTree1(TreeNode p, TreeNode q) {// 递归
		// if(p == null || q==null) return p==q;
		// return (p.val == q.val)&&isSameTree(p.left,q.left) &&
		// isSameTree(p.right,q.right);
		if (p == null && q == null)
			return true;
		if (p == null && q != null)
			return false;
		if (p != null && q == null)
			return false;
		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

}
