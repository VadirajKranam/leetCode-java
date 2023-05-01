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
    public int numComponents(ListNode head, int[] nums) {
        int size=0;
        int common=0;
        Set<Integer> s=new HashSet<>();
        for(int n:nums)
        {
            s.add(n);
        }
        ListNode t=head;
        while(t!=null)
        {
            if(s.contains(t.val))
            {
                size++;
            }
            else
            {
                if(size>0)
                {
                    common++;
                }
                size=0;
            }
            t=t.next;
        }
        if(size>0)
        {
            common++;
        }
        return common;
    }
}