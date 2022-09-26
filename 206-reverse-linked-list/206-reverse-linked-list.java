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
    public ListNode reverseList(ListNode head) {
        if(head==null)
        {
            return null;
        }
        ListNode ans=new ListNode(head.val);
        ListNode temp=head.next;
        while(temp!=null)
        {
            ListNode n=new ListNode(temp.val);
            ListNode t=ans;
            ans=n;
            ans.next=t;
            temp=temp.next;
        }
        return ans;
    }
}