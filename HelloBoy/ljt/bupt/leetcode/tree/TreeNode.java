package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode buildTree(int[] nums) {// 按照值的大小创建一棵树
		if (nums.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(nums[0]);
		for (int i = 1; i < nums.length; i++) {
			insert(root, nums[i]);
		}
		return root;
	}

	public static TreeNode createBinTree(int[] array) {// 层序的创建出一个树
		List<TreeNode> nodeList = new LinkedList<TreeNode>();
		// 将一个数组的值依次转换为Node节点
		for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
			nodeList.add(new TreeNode(array[nodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子
		nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
		}
		return nodeList.get(0);
	}
	private static void DFSTraversal(TreeNode root) {
		
		
	}

	private static void BFSTraversal(TreeNode root) {
		
		
	}

	public static void PreOrderTravercal(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		PreOrderTravercal(root.left);
		PreOrderTravercal(root.right);
	}

	private static void midOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		midOrderTraversal(root.left);
		System.out.print(root.val + " ");

		midOrderTraversal(root.right);

	}

	private static void afterOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		afterOrderTraversal(root.left);
		afterOrderTraversal(root.right);
		System.out.print(root.val + " ");

	}

	// 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	// 思路还是很清晰的，使用两个队列一个存放节点，一个存放值。
	// 先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，
	// 访问该元素的左右节点，再将左右子节点加入到队列中来
	public static ArrayList<Integer> levelPrintTree(TreeNode root) {// 分层打印
		ArrayList<Integer> intList = new ArrayList<Integer>();
		ArrayList<TreeNode> treeList = new ArrayList<TreeNode>();
		if (root == null) {
			return intList;
		}
		treeList.add(root);
		for (int i = 0; i < treeList.size(); i++) {
			TreeNode node = treeList.get(i);
			if (node.left != null) {
				treeList.add(node.left);
			}
			if (node.right != null) {
				treeList.add(node.right);
			}
			intList.add(node.val);
		}
		return intList;
	}

	private static void insert(TreeNode root, int data) {
		if (data > root.val) {
			if (root.right != null) {
				insert(root.right, data);
			} else {
				root.right = new TreeNode(data);
			}
		} else {
			if (root.left == null) {
				root.left = new TreeNode(data);
			} else {
				insert(root.left, data);
			}
		}
	}
}
