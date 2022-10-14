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
    public ListNode deleteMiddle(ListNode head) {
        int length=0;
        ListNode temp=head;
        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }
        if(length==1)
        {
            return null;
        }
       // System.out.println(length);
        if(length%2==1)
        {
            int l=length/2;
            temp=head;
            while(l!=1)
            {
                temp=temp.next;
                l--;
            }
            temp.next=temp.next.next;
        }
        else
        {
            int l=length/2;
            temp=head;
            while(l!=1)
            {
                temp=temp.next;
                l--;
            }
            temp.next=temp.next.next;
        }
        return head;
    }
}