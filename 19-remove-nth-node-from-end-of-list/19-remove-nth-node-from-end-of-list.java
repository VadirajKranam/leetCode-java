/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        {
            return null;
        }
        if(n==0)
        {
            return head;
        }
        ListNode ans=new ListNode(head.val);
        if(head.next==null)
        {
            if(n>=1)
            {
                return null;
            }
            else 
            {
                return head; 
            }
        }
        ListNode t=head;
        int l=0;
        while(t!=null)
        {
            t=t.next;
            l++;
        }
        int f=l-n+1;
        int s=0;
        if(f==1)
        {
            head=head.next;
            return head;
        }
        t=head;
        while(s<f-2)
        {
          t=t.next;
          s++;
        }
        t.next=t.next.next;
        return head;
    }
}