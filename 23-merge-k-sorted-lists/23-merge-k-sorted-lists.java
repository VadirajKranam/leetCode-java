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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        {
            return null;
        }
      ArrayList<Integer> sorted=new ArrayList<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp=lists[i];
            while(temp!=null)
            {
                sorted.add(temp.val);
                temp=temp.next;
            }
        }
        if(sorted.size()==0)
        {
            return null;
        }
        Collections.sort(sorted);
        ListNode head=new ListNode(sorted.get(0));
        ListNode temp=head;
        for(int i=1;i<sorted.size();i++)
        {
            ListNode node=new ListNode(sorted.get(i));
            temp.next=node;
            temp=node;
            temp.next=null;
        }
        return head;
    }
}