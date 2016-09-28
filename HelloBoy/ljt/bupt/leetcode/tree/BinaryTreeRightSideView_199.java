package ljt.bupt.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView_199 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		TreeNode root = TreeNode.createBinTree(nums);
		List<Integer> res = rightSisdeView2(root);
		System.out.println(res);
	}

	private static List<Integer> rightSisdeView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		rightView(root,list);
		return list;
	}

	private static void rightView(TreeNode root, List<Integer> list) {//error
		if (root == null)
			return ;
		list.add(root.val);
		if (root.right != null) {
			rightView(root.right,list);
		} else if (root.left != null) {
			rightView(root.left,list);
		} else {
			return ;
		}
		
	}

	// The core idea of this algorithm:
	//
	// 1.Each depth of the tree only select one node.
	//
	// View depth is current size of result list.
	//
	// Here is the code:
	private static List<Integer> rightSisdeView2(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		rightView(root, result, 0);
		return result;
	}

	private static void rightView(TreeNode curr, List<Integer> result, int currDepth) {
		if (curr == null) {
			return;
		}
		if (currDepth == result.size()) {
			result.add(curr.val);
		}

		rightView(curr.right, result, currDepth + 1);
		rightView(curr.left, result, currDepth + 1);

	}

	// BFS,一层一层遍历，将每一层的最后一个元素加入list
	private static List<Integer> rightSisdeView1(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null)
			return list;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (i == size - 1) {
					list.add(tmp.val);
				}
			}
		}
		return list;
	}

}
