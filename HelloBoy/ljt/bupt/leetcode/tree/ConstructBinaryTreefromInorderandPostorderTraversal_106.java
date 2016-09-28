package ljt.bupt.leetcode.tree;

import java.util.ArrayList;

public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

	public static void main(String[] args) {
		int[] inorder = { 1,2 };
		int[] postorder = { 1,2 };
		TreeNode res = buildTree(inorder, postorder);
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
		int len = postorder.length;
		int rootVal = postorder[len-1];
		TreeNode root = new TreeNode(rootVal);

		ArrayList<Integer> beforininorder = new ArrayList<>();//储存中序遍历中的根左子树上的节点
		ArrayList<Integer> afterininorder = new ArrayList<>();

		boolean flag = false;
		for (int i = 0; i < inorder.length; i++) {
			if(inorder[i] != rootVal&&flag==false){
				beforininorder.add(inorder[i]);
			}
			if(inorder[i] == rootVal){
				flag = true;
			}
			if(inorder[i] != rootVal&&flag==true){
				afterininorder.add(inorder[i]);
			}
		}
		
		
		int[] beforArrayinorder = null;
		if(beforininorder.size()!=0){
			beforArrayinorder = new int[beforininorder.size()];
			for(int i = 0 ; i<beforininorder.size(); i++){
				beforArrayinorder[i] = beforininorder.get(i);
			}
		}
			
		int[] afterArrayinorder = null;
		if(afterininorder.size()!=0){
			afterArrayinorder = new int[afterininorder.size()];
			for(int i = 0 ; i<afterininorder.size(); i++){
				afterArrayinorder[i] = afterininorder.get(i);
			}
		}
		
		
		
		ArrayList<Integer> beforinpostorder = new ArrayList<>();//储存后续遍历中的根左子树上的节点
		ArrayList<Integer> afterinpostorder = new ArrayList<>();
		
		for(int i = 0; i < beforininorder.size() ; i++){
			beforinpostorder.add(postorder[i]);
		}
		for(int i = beforininorder.size(); i < postorder.length-1 ; i++){
			afterinpostorder.add(postorder[i]);
		}
		
		int[] beforArrayinpostorder = null;
		if(beforinpostorder.size()!=0){
			beforArrayinpostorder = new int[beforininorder.size()];
			for(int i = 0 ; i<beforininorder.size(); i++){
				beforArrayinpostorder[i] = beforinpostorder.get(i);
			}
		}
		
		int[] afterArrayinpostorder = null;
		if(afterininorder.size()!=0){
			afterArrayinpostorder = new int[afterinpostorder.size()];
			for(int i = 0 ; i<afterinpostorder.size(); i++){
				afterArrayinpostorder[i] = afterinpostorder.get(i);
			}
		}
		
		
		TreeNode left = build(beforArrayinorder, beforArrayinpostorder);
//		if(left==null)
//			return null;
		if(left!=null)
			root.left = left;
		TreeNode right = build(afterArrayinorder, afterArrayinpostorder);
//		if(right==null)
//			return null;
		if(right!=null)
			root.right = right;
		return root;
	}

}
