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
    public ListNode removeElements(ListNode head, int val) {
        ListNode h2=new ListNode();
        ListNode temp=head;
        ListNode t=h2;
        while(temp!=null)
        {
            if(temp.val!=val)
            {
                ListNode newNode=new ListNode(temp.val);
                t.next=newNode;
                t=t.next;
            }
            temp=temp.next;
        }
        return h2.next;
    }
}