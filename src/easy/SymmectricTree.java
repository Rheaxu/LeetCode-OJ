package easy;

import java.util.ArrayList;
import java.util.Stack;

import datastructure.TreeNode;

public class SymmectricTree {
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(4);
		SymmectricTree st = new SymmectricTree();
		System.out.println(st.isSymmetric2(root));
	}
	
	/**
	 * Recursive version: other's
	 * @param root
	 * @return
	 */
	public boolean isSymmetric1(TreeNode root) 
	{
		return (root==null || isSymmetrichelper(root.left,root.right));
	}	
	public boolean isSymmetrichelper(TreeNode left,TreeNode right)
	{
		if(left==null || right==null) return left==right;
		if(left.val!=right.val)return false;
		return isSymmetrichelper(left.left,right.right) && isSymmetrichelper(left.right,right.left);
	}
	
	
	/**
	 * Stack version: other's
	 */
	public boolean isSymmetric2(TreeNode root)
	{
		if(root==null) return true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode left,right;
		if(root.left!=null)
		{
			if(root.right == null)return false;
			stack.push(root.left);
			stack.push(root.right);
		}
		else if(root.right!=null) return false;
		
		while(!stack.isEmpty())
		{
			if(stack.size()%2!=0) return false;
			right = stack.pop();
			left = stack.pop();
			if(right.val!=left.val)return false;
			if(left.left!=null)
			{
				if(right.right==null) return false;
				stack.push(left.left);
				stack.push(right.right);
			}
			else if(right.right!=null) return false;
			if(left.right!=null)
			{
				if(right.left==null) return false;
				stack.push(left.right);
				stack.push(right.left);
			}
			else if(right.left!=null) return false;
		}
		
		return true;
	}
}
