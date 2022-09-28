/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hs=new HashSet<>();
        ListNode t=headA;
        while(t!=null)
        {
            hs.add(t);
            t=t.next;
        }
        t=headB;
        while(t!=null)
        {
            if(hs.contains(t))
            {
                return t;
            }
            t=t.next;
        }
        return null;
    }
}