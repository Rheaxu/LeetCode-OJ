package easy;

import java.util.ArrayList;

import datastructure.TreeNode;

public class BinTreeBalanced {
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		/*root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.left.left.left.left = new TreeNode(5);
		root.left.left.left.right = new TreeNode(5);
		root.left.left.right = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(4);
		root.left.right.right = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		//root.right.left.left = new TreeNode(4);
		//root.right.left.right = new TreeNode(4);
		root.right.right = new TreeNode(3);*/
		//root.right.right.left = new TreeNode(5);
		//root.right.right.right = new TreeNode(5);
		BinTreeBalanced btmd = new BinTreeBalanced();
		System.out.println(btmd.isBalanced(root));
	}
	
	/**
	 * The method is got by referring to other's answer.
	 * Definition of balance tree: binary tree is defined as a binary tree in 
	 * which the depth of the two subtrees of every node never differ by more than 1.
	 */
	boolean isbalance = true;
	
	public boolean isBalanced(TreeNode root) 
	{
		if(root == null) return true;
		getheight(root);
		return isbalance;
    }
	
	public int getheight(TreeNode root)
	{
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		int lefth = 1+getheight(root.left);
		int righth = 1+getheight(root.right);
		if(Math.abs(lefth-righth)>1) isbalance=false;
		
		return Math.max(lefth, righth);
	}

}
