package easy;

import java.util.ArrayList;
import java.util.List;

import datastructure.TreeNode;

public class BinTreeLevelOrderTraversal {

	
	public List<List<Integer>> levelOrder(TreeNode root) {
        
		ArrayList<List<Integer>> vals = new ArrayList<List<Integer>>();
		if(root == null) return vals;
		ArrayList<TreeNode> tovisit = new ArrayList<TreeNode>();
		int lastlyrcount = 1;
		tovisit.add(root);
		ArrayList<Integer> rootlist = new ArrayList<Integer>();
		rootlist.add(root.val);
		vals.add(rootlist);
		while(!tovisit.isEmpty())
		{
			int curlyrcount = 0;
			List<Integer> curlyrlist = new ArrayList<Integer>();
			while(lastlyrcount>0)
			{
				TreeNode curnode = tovisit.get(0);
				tovisit.remove(0);
				if(curnode.left!=null) 
				{
					tovisit.add(curnode.left);
					curlyrlist.add(curnode.left.val);
					curlyrcount++;
				}
				if(curnode.right!=null)
				{
					tovisit.add(curnode.right);
					curlyrlist.add(curnode.right.val);
					curlyrcount++;
				}
				lastlyrcount--;
			}
			if(curlyrlist.size()!=0)vals.add(curlyrlist);
			lastlyrcount = curlyrcount;
		}
		
		return vals;
    }
}
