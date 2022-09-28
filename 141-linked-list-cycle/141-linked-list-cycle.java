/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
        {
            return false;
        }
      ListNode f=head;
      ListNode s=head;
      while(s.next!=null && s.next.next!=null)
      {
          f=f.next;
          s=s.next.next;
          if(s==f)
          {
              return true;
          }
      }
        return false;
    }
}