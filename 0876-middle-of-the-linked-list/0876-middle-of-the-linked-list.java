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
    public ListNode middleNode(ListNode head) {
        int len=0;
        ListNode t=head;
        while(t!=null)
        {
            t=t.next;
            len++;
        }
      
       len=len/2;
       t=head;
        while(len!=0)
        {
            t=t.next;
            len--;
        }
        return t;
    }
}