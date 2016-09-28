package ljt.bupt.leetcode.tree;

import java.util.LinkedList;

public class SumRoottoLeafNumbers_129 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5 };
		TreeNode root = TreeNode.createBinTree(nums);
		int res = sumNumbers(root);
		System.out.println(res);

	}

	private static int sumNumbers(TreeNode root) {//DFS使用stack实现
		if(root==null)
			return 0;
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> value = new LinkedList<>();
		int sum = 0;
		stack.addFirst(root);
		value.addFirst(root.val);
		while(!stack.isEmpty()){
			TreeNode tmpRoot = stack.removeFirst();
			int tmpVal = value.removeFirst();
			if(tmpRoot.right!=null){
				stack.addFirst(tmpRoot.right);
				int v = 10*tmpVal + tmpRoot.right.val;
				value.addFirst(v);
			}
			if(tmpRoot.left!=null){
				stack.addFirst(tmpRoot.left);
				int v = 10*tmpVal + tmpRoot.left.val;
				value.addFirst(v);
			}
			if(tmpRoot.left==null&&tmpRoot.right==null){
				sum += tmpVal;
			}
		}
		return sum;
	}

	private static int sumNumbers1(TreeNode root) {//AC,但是改变了树节点的值
		return getSum(root);
	}

	private static int getSum(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			return root.val;
		}
		if (root.left != null && root.right == null) {
			root.left.val += 10 * root.val;
			return getSum(root.left);

		} else if (root.left == null && root.right != null) {
			root.right.val += 10 * root.val;
			return getSum(root.right);
		} else if (root.left != null && root.right != null) {
			root.left.val += 10 * root.val;
			root.right.val += 10 * root.val;
			return getSum(root.left) + getSum(root.right);
		} else {
			return 0;
		}
	}

}
