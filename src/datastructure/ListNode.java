package datastructure;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) {
		val = x;
		next = null;
	}
	
	public ListNode(int[] xlist){
		if(xlist.length == 0) return;
		val = xlist[0];
		//ListNode  = new ListNode(xlist[0]);
		ListNode last = this;
		for(int i=1;i<xlist.length;i++)
		{
			ListNode cur = new ListNode(xlist[i]);
			last.next = cur;
			last = cur;
		}
	}
}
