package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementinaBST_230 {

	public static void main(String[] args) {
		int[] nums = { 10, 5, 15, 3, 7, 12, 20 };
		TreeNode root = TreeNode.createBinTree(nums);
		int k = 3;
		int res = kthSmallest1(root, k);
		System.out.println(res);

	}
	static List<Integer> list = new ArrayList<>();
	// 可以中序遍历这棵树得到一个排序后的数组，然后得到该数组第k-1个值就行
	private static int kthSmallest1(TreeNode root, int k) {
		list = MidOrder(root);
//		for(Integer l :list){
//			System.out.println(l);
//		}
//		System.out.println(list.get(k-1));
		return (int) list.get(k - 1);
	}

	

	private static List<Integer> MidOrder(TreeNode root) {
		if(root.left!=null)
			MidOrder(root.left);
		list.add(root.val);
		if(root.right!=null)
		MidOrder(root.right);
		return list;
	}

	private static int kthSmallest(TreeNode root, int k) {// 递归
		int leftSize = countTreeSize(root.left);
		if (k == leftSize + 1) {
			return root.val;
		} else if (k <= leftSize) {
			return kthSmallest(root.left, k);
		} else {
			return kthSmallest(root.right, k - leftSize - 1);
		}
	}

	private static int countTreeSize(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + countTreeSize(root.left) + countTreeSize(root.right);
	}
}
