package ljt.bupt.leetcode.tree;

public class ConvertSortedArraytoBinarySearchTree_108 {

	public static void main(String[] args) {
		int[] nums = { 10, 5, 15, 3, 7, 12, 20 };
		TreeNode res = sortedArrayToBST(nums);
		TreeNode.levelPrintTree(res);
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		int element = getMidIndexElement(nums, 0, nums.length - 1);
		TreeNode root = new TreeNode(element);

		return null;
	}

	private static int getMidIndexElement(int[] nums, int i, int j) {

		return 0;
	}
}
