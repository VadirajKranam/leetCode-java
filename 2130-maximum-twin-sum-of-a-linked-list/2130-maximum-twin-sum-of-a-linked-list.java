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
    public int pairSum(ListNode head) {
        ArrayList<Integer> a=new ArrayList<>();
        ListNode t=head;
        while(t!=null)
        {
            a.add(t.val);
            t=t.next;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<=a.size()/2;i++)
        {
            max=Math.max(max,a.get(i)+a.get(a.size()-i-1));
        }
        return max;
    }
}