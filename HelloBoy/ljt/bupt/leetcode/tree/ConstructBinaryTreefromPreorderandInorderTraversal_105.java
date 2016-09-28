package ljt.bupt.leetcode.tree;

import java.util.ArrayList;

public class ConstructBinaryTreefromPreorderandInorderTraversal_105 {

	public static void main(String[] args) {
		int[] preorder = { 1,2,4,5,3,6,7 };
		int[] inorder = { 4,2,5,1,6,3,7 };
		TreeNode res = buildTree(preorder, inorder);
		TreeNode.PreOrderTravercal(res);
	}

	private static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder==null||postorder==null||inorder.length==0 || postorder.length == 0)
			return null;
		TreeNode root = build(inorder, postorder);
		return root;
	}

	private static TreeNode build(int[] inorder, int[] postorder) {
		if(inorder==null||postorder==null)
			return null;
		int rootVal = inorder[0];
		TreeNode root = new TreeNode(rootVal);

		ArrayList<Integer> beforinpostorder = new ArrayList<>();//储存中序遍历中的根左子树上的节点
		ArrayList<Integer> afterinpostorder = new ArrayList<>();

		boolean flag = false;
		for (int i = 0; i < postorder.length; i++) {
			if(postorder[i] != rootVal&&flag==false){
				beforinpostorder.add(postorder[i]);
			}
			if(postorder[i] == rootVal){
				flag = true;
			}
			if(postorder[i] != rootVal&&flag==true){
				afterinpostorder.add(postorder[i]);
			}
		}
		
		
//		Integer[] beforArrayinpostorder = null;
		int[] beforArraypostorder = null;
		if(beforinpostorder.size()!=0){
//			beforArrayinpostorder = new Integer[beforinpostorder.size()];
//			beforArrayinpostorder = beforinpostorder.toArray(beforArrayinpostorder);
			beforArraypostorder = new int[beforinpostorder.size()];
			for(int i = 0 ; i<beforinpostorder.size(); i++){
				beforArraypostorder[i] = beforinpostorder.get(i);
			}
		}
			
//		Integer[] afterArrayinpostorder = null;
		int[] afterArraypostorder = null;
		if(afterinpostorder.size()!=0){
//			afterArrayinpostorder = new Integer[afterinpostorder.size()];
//			afterArrayinpostorder = afterinpostorder.toArray(afterArrayinpostorder);
			afterArraypostorder = new int[afterinpostorder.size()];
			for(int i = 0 ; i<afterinpostorder.size(); i++){
				afterArraypostorder[i] = afterinpostorder.get(i);
			}
		}
		
		
		
		ArrayList<Integer> beforininorder = new ArrayList<>();//储存前序遍历中的根左子树上的节点
		ArrayList<Integer> afterininorder = new ArrayList<>();
		
		for(int i = 1; i < beforinpostorder.size()+1 ; i++){
			beforininorder.add(inorder[i]);
		}
		for(int i = beforinpostorder.size()+1; i < inorder.length ; i++){
			afterininorder.add(inorder[i]);
		}
		
//		Integer[] beforArrayininorder = null;
		int[] beforArrayinorder = null;
		if(beforininorder.size()!=0){
//			beforArrayininorder = new Integer[beforininorder.size()];
//			beforArrayininorder = beforininorder.toArray(beforArrayininorder);
			beforArrayinorder = new int[beforininorder.size()];
			for(int i = 0 ; i<beforininorder.size(); i++){
				beforArrayinorder[i] = beforininorder.get(i);
			}
		}
		
//		Integer[] afterArrayininorder = null;
		int[] afterArrayinorder = null;
		if(afterininorder.size()!=0){
//			afterArrayininorder = new Integer[afterininorder.size()];
//			afterArrayininorder = afterininorder.toArray(afterArrayininorder);
			afterArrayinorder = new int[afterininorder.size()];
			for(int i = 0 ; i<afterininorder.size(); i++){
				afterArrayinorder[i] = afterininorder.get(i);
			}
		}
		
		
		TreeNode left = build(beforArrayinorder, beforArraypostorder);
//		if(left==null)
//			return null;
		if(left!=null)
			root.left = left;
		TreeNode right = build(afterArrayinorder, afterArraypostorder);
//		if(right==null)
//			return null;
		if(right!=null)
			root.right = right;
		return root;
	}

}
