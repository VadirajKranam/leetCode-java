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
    public ListNode swapPairs(ListNode head) {
        ArrayList<ListNode> a=new ArrayList<>();
        ListNode t=head;
        while(t!=null)
        {
            a.add(t);
            t=t.next;
        }
        for(int i=0;i<a.size()-1;i+=2)
        {
            ListNode t1=a.get(i);
            a.set(i,a.get(i+1));
            a.set(i+1,t1);
        }
        if(a.size()==1 || a.size()==0)
        {
            return head;
        }
        a.get(a.size()-1).next=null;
        head=a.get(0);
        t=head;
        for(int i=1;i<a.size();i++)
        {
            //System.out.println(t.val);
            t.next=a.get(i);
            t=t.next;
        }
        //System.out.println(t.val);
        return head;
    }
}