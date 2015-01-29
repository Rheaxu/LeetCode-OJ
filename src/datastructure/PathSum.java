package datastructure;

import java.util.ArrayList;

/**
 * 
 * @author Ruiyu Xu
 * @time Jan 1st 2015
 * @About: Given a binary tree and a sum, determine if the tree has a 
 * 		root-to-leaf path such that adding up all the values along the 
 * 		path equals the given sum.
 *
 */
public class PathSum {
	
	public static void main(String args[])
	{
		TreeNode root = null;
		/*TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);*/
		PathSum ps = new PathSum();
		System.out.println(ps.hasPathSum1(root, 22));
		
	}
	
	/**
	 * This method only judges whether it's true or false
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum1(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum1(root.left,sum-root.val) || hasPathSum1(root.right,sum-root.val);
    }
	
	/**
	 * This method tracks the root
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum2(TreeNode root,int sum)
	{
		if(root == null) return false;
		ArrayList<TreeNode> pathsum = new ArrayList<TreeNode>();
		ArrayList<TreeNode> toVisitNode = new ArrayList<TreeNode>();
		ArrayList<TreeNode> visitedNode = new ArrayList<TreeNode>();
		toVisitNode.add(root);
		while(!toVisitNode.isEmpty())
		{
			TreeNode curnode = toVisitNode.get(toVisitNode.size()-1);
			visitedNode.add(curnode);
			toVisitNode.remove(curnode);
			if(pathsum.size()>1)
			{
				while(pathsum.get(pathsum.size()-1).left != curnode && pathsum.get(pathsum.size()-1).right != curnode)
					pathsum.remove(pathsum.size()-1);
			}
			pathsum.add(curnode);
			if(curnode.left == null && curnode.right == null)
				if(listsum(pathsum) == sum)
					return true;
				else
					pathsum.remove(curnode);
			else if(curnode.left == null)
				toVisitNode.add(curnode.right);
			else if (curnode.right == null)
				toVisitNode.add(curnode.left);
			else
			{
				toVisitNode.add(curnode.right);
				toVisitNode.add(curnode.left);
			}
		}
		
		return false;
	}
	
	public int listsum(ArrayList<TreeNode> path)
	{
		int sum = 0;
		for(TreeNode node:path)
			sum += node.val;
		return sum;
	}
}
