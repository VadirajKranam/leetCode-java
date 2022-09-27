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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> a=new ArrayList<Integer>();
        ListNode t=list1;
        while(t!=null)
        {
            a.add(t.val);
            t=t.next;
        }
        t=list2;
        while(t!=null)
        {
            a.add(t.val);
            t=t.next;
        }
        Collections.sort(a);
        if(a.size()==0)
        {
            return null;
        }
        ListNode ans=new ListNode(a.get(0));
        t=ans;
        for(int i=1;i<a.size();i++)
        {
            ListNode n=new ListNode(a.get(i));
            t.next=n;
            t=n;
        }
        return ans;
    }
}