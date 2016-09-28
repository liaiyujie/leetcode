package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths_257 {

	static List<String> res = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 455, 5, 6, 7 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<String> res = binaryTreePaths(root);
		System.out.println(res);
		// 测试了StringBuilder的一个方法，该方法有截取字符串的作用
		// StringBuilder sb = new StringBuilder("1234567789");
		// sb.setLength(4);
		// System.out.println(sb.toString());

	}

	// The time complexity for the problem should be O(n),
	// since we are basically visiting each node in the tree.
	// Yet an interviewer might ask you for further optimization
	// when he or she saw a string concatenation. A string concatenation is just
	// too costly.
	// A StringBuilder can be used although a bit tricky since it is not
	// immutable like string is.
	//
	// When using StringBuilder, We can just keep track of the length of the
	// StringBuilder
	// before we append anything to it before recursion and
	// afterwards set the length back. Another trick is when to append the "->",
	// since we don't need the last arrow at the end of the string, we only
	// append it
	// before recurse to the next level of the tree. Hope the solution helps!
	private static List<String> binaryTreePaths(TreeNode root) {// 使用了StringBuilder，减少了字符串拼接的次数
		List<String> res = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		helper(res, root, sb);
		return res;
	}

	private static void helper(List<String> res, TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		int len = sb.length();
		sb.append(root.val);
		if (root.left == null && root.right == null) {
			res.add(sb.toString());
		} else {
			sb.append("->");
			helper(res, root.left, sb);
			helper(res, root.right, sb);
		}
		sb.setLength(len);

	}

	private static List<String> binaryTreePaths1(TreeNode root) {// 递归求解
		List<String> answer = new ArrayList<String>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private static void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
	}
}
