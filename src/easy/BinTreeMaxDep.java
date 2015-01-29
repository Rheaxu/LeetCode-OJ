package easy;

import java.util.ArrayList;

import datastructure.TreeNode;

public class BinTreeMaxDep {
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(5);
		BinTreeMaxDep btmd = new BinTreeMaxDep();
		System.out.println(btmd.maxDepth(root));
	}
	
	public int maxDepth(TreeNode root) 
	{
		if(root == null) return 0;
		int pathlen = 0;
		ArrayList<TreeNode> tovisit = new ArrayList<TreeNode>();
		tovisit.add(root);
		int lastlyrlen = 1;
		while(!tovisit.isEmpty())
		{
			TreeNode curnode = tovisit.get(0);
			int curlyrlen = 0;
			while(lastlyrlen>0)
			{
				curnode = tovisit.get(0);
				tovisit.remove(0);
				if(curnode.left!=null)
				{
					curlyrlen++;
					tovisit.add(curnode.left);
				}
				if(curnode.right!=null)
				{
					curlyrlen++;
					tovisit.add(curnode.right);
				}
				lastlyrlen--;
			}
			pathlen++;
			lastlyrlen = curlyrlen;
		}
		
		return pathlen;
    }
}
