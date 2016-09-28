package ljt.bupt.leetcode.tree;

public class FlattenBinaryTreetoLinkedList_114 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = TreeNode.createBinTree(nums);
		flatten(root);
		TreeNode.levelPrintTree(root);
	}

	private static void flatten(TreeNode root) {
		if(root == null)
			return ;
		helper(root);
		
	}

	private static void helper(TreeNode root) {
		TreeNode left = null;
		TreeNode right= null;
		if(root.left!=null){
			left = root.left;
		}
		if(root.right!=null){
			right = root.right;
		}
		root.right = left;
		helper(root.left);
		root.right.right = right;
		helper(root.right);
	}

}
