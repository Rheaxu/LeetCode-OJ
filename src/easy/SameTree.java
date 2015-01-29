package easy;

import java.util.Stack;

import datastructure.TreeNode;

public class SameTree {

	/**
	 * Other's concise solution 1
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree2(TreeNode p, TreeNode q)
	{
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		if(p.val==q.val) 
			return isSameTree2(p.left,q.left) && isSameTree2(p.right,q.right);
		return false;
	}
	
	public boolean isSameTree3(TreeNode p,TreeNode q)
	{
		if(p==null || q==null) return p==q;
		else
			return (p.val==q.val)&&isSameTree3(p.left,q.left)&&isSameTree3(p.right,q.right);
	}
	
	/**
	 * My Solution
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTre1e(TreeNode p, TreeNode q) {
        Stack<TreeNode> tovisit1 = new Stack<TreeNode>();
        Stack<TreeNode> tovisit2 = new Stack<TreeNode>();
        
        if(p!=null&&q==null || p==null&&q!=null) return false;
        if(p==null&&q==null) return true;
        tovisit1.push(p);
        tovisit2.push(q);
        while(!tovisit1.isEmpty() && !tovisit2.isEmpty())
        {
        	TreeNode curnode1 = tovisit1.pop();
        	TreeNode curnode2 = tovisit2.pop();
        	if(curnode1.val!=curnode2.val)return false;
        	if(curnode1.right!=null)
        	{
        		if(curnode2.right==null) return false;
        		tovisit1.push(curnode1.right);
        		tovisit2.push(curnode2.right);
        	}
        	else if(curnode2.right!=null) return false;
        	if(curnode1.left!=null)
        	{
        		if(curnode2.left==null) return false;
        		tovisit1.push(curnode1.left);
        		tovisit2.push(curnode2.left);
        	}
        	else if(curnode2.left!=null) return false;
        }
        
        if(!tovisit1.isEmpty() || !tovisit2.isEmpty()) return false;
        return true;
    }
}
