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
        ListNode temp=head;
        int l=0;
        if(head==null)
        {
            return null;
        }
        while(temp!=null)
        {
            l++;
            temp=temp.next;
        }
        int count=0;
        temp=head;
        while(count<l/2)
        {
            temp=temp.next;
            count++;
        }
        return temp;
    }
}