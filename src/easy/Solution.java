package easy;

import datastructure.ListNode;

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
        ListNode lastnode = head;
        ListNode curnode = head.next;
        while(curnode!=null)
        {
            if(curnode.val == lastnode.val)
            {
                lastnode.next = curnode.next;
                curnode = lastnode.next;
            }
            else
            {
                lastnode = curnode;
                curnode = curnode.next;
            }
        }
        
        return lastnode;
    }
}