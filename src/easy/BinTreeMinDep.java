package easy;

import java.util.ArrayList;

import datastructure.TreeNode;

public class BinTreeMinDep {
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		BinTreeMinDep btmd = new BinTreeMinDep();
		System.out.println(btmd.minDepth2(root));
	}
	
	/**
	 * My solution: BFS
	 * @param root
	 * @return
	 */
	public int minDepth1(TreeNode root)
	{
		if(root == null) return 0;
		ArrayList<TreeNode> tovisit = new ArrayList<TreeNode>();
		int pathlen = 1, lastlyrnodenum = 1;
		tovisit.add(root);
		while(!tovisit.isEmpty())
		{	
			
			int curlyrnodenum = 0;
			while(lastlyrnodenum > 0)
			{
				TreeNode curnode = tovisit.get(0);
				tovisit.remove(0);
				if(curnode.right == null && curnode.left == null)
					return pathlen;
				if(curnode.left != null)
				{
					tovisit.add(curnode.left);
					curlyrnodenum++;
				}
				if(curnode.right != null)
				{
					tovisit.add(curnode.right);
					curlyrnodenum++;
				}
				lastlyrnodenum--;
			}
			pathlen++;
			lastlyrnodenum = curlyrnodenum;				
		}
		
		return pathlen;
	}
	
	/**
	 * DFS referred to other's
	 */
	public int minDepth2(TreeNode root)
	{
		if(root == null) return 0;
		int left = 1+minDepth2(root.left);
		int right = 1+minDepth2(root.right);
		if(left == 1) return right;
		if(right == 1) return left;
		if(left>right) return right;
		else return left;
	}
}
