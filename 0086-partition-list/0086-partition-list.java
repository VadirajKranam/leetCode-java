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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> a1=new ArrayList<>();
        ArrayList<Integer> a2=new ArrayList<>();
        ListNode node=head;
        while(node!=null)
        {
            if(node.val<x)
            {
                a1.add(node.val);
            }
            else
            {
                a2.add(node.val);
            }
            node=node.next;
        }
        node=head;
        for(int i=0;i<a1.size();i++)
        {
            node.val=a1.get(i);
            node=node.next;
        }
        for(int i=0;i<a2.size();i++)
        {
            node.val=a2.get(i);
            node=node.next;
        }
        return head;
    }
}