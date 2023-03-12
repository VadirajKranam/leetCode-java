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
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<lists.length;i++)
        {
            ListNode temp=lists[i];
            while(temp!=null)
            {
                ans.add(temp.val);
               
                temp=temp.next;
                
            }
        }
        Collections.sort(ans);
        ListNode node=new ListNode();
        ListNode temp=node;
        for(int i=0;i<ans.size();i++)
        {
            ListNode newNode=new ListNode(ans.get(i));
            temp.next=newNode;
            temp=temp.next;
        }
        return node.next;
    }
}