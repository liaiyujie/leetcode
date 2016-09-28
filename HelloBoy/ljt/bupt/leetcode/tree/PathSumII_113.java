package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumII_113 {

	public static void main(String[] args) {
		int[] nums = { 5, 4, 8, 11, 0, 13, 4, 7, 2, 0, 0, 5, 1 };
		int sum = 22;
		TreeNode root = TreeNode.createBinTree(nums);
		List<List<Integer>> res = pathSum(root, sum);
		for (List list : res) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> value = new LinkedList<>();
		LinkedList<Integer> ans = new LinkedList<>();
		stack.addFirst(root);
		value.addFirst(root.val);
		while (!stack.isEmpty()) {
			TreeNode tmpRoot = stack.removeFirst();
			ans.addFirst(tmpRoot.val);
			int tmpVal = value.removeFirst();
			if (tmpRoot.right != null) {
				stack.addFirst(tmpRoot.right);
				value.addFirst(tmpVal + tmpRoot.right.val);
			}
			if (tmpRoot.left != null) {
				stack.addFirst(tmpRoot.left);
				value.addFirst(tmpVal + tmpRoot.left.val);
			}
			if (tmpRoot.left == null && tmpRoot.right == null) {
				if (tmpVal == sum) {
					List<Integer> l = new ArrayList<>();
					l.addAll(ans);//
					res.add(l);
				} else {
					ans.removeFirst();
				}
			}
		}
		return res;
	}

}
