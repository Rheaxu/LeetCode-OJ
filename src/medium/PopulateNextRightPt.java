package medium;

import java.util.ArrayList;

import datastructure.TreeLinkNode;

public class PopulateNextRightPt {
	
	public static void main(String[] args)
	{
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		PopulateNextRightPt pnrp = new PopulateNextRightPt();
		pnrp.connect(root);
	}
	
	/**
	 * O(1) space by referring to other's: use the "next"
	 */
	public void connect2(TreeLinkNode root)
	{
		if(root == null) return;
		TreeLinkNode pre = root;
		TreeLinkNode cur = null;
		while(pre.left!=null)
		{
			cur = pre;
			while(cur!=null)
			{
				cur.left.next = cur.right;
				if(cur.next!=null) cur.right.next = cur.next.left;
				cur = cur.next;
			}
			pre = pre.left;
		}
	}
	
	/**
	 * My solution, a BAD one because space is not constant.
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		if(root==null)return;
        ArrayList<TreeLinkNode> queue = new ArrayList<TreeLinkNode>();
        queue.add(root);
        int lastlyrnodenum = 1;
        while(!queue.isEmpty())
        {
        	int curlyrnodenum = 0;
        	TreeLinkNode lastnode = queue.get(0);
        	queue.remove(0);
        	lastlyrnodenum--;
        	if(lastnode.left!=null)
        	{
        		queue.add(lastnode.left);
        		curlyrnodenum++;
        	}
        	if(lastnode.right!=null)
        	{
        		queue.add(lastnode.right);
        		curlyrnodenum++;
        	}
        	while(lastlyrnodenum>0)
        	{
        		TreeLinkNode curnode = queue.get(0);
        		queue.remove(0);
        		lastnode.next = curnode;
            	if(curnode.left!=null)
            	{
            		queue.add(curnode.left);
            		curlyrnodenum++;
            	}
            	if(curnode.right!=null)
            	{
            		queue.add(curnode.right);
            		curlyrnodenum++;
            	}
            	lastnode = curnode;
            	lastlyrnodenum--;
        	}
        	lastlyrnodenum = curlyrnodenum;
        }
    }
}
