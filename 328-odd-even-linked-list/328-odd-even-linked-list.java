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
    public ListNode oddEvenList(ListNode head) {
       ArrayList<Integer> odi=new ArrayList<>();
       ArrayList<Integer> evi=new ArrayList<>();
        int o=1;
        ListNode node=head;
        
        while(node!=null)
        {
            if(o==1)
            {
                odi.add(node.val);
                o=-1;
            }
            else
            {
                evi.add(node.val);
                o=1;
            }
            node=node.next;
        }
        node=head;
            for(int i=0;i<odi.size();i++)
            {
                node.val=odi.get(i);
                node=node.next;
            }
        for(int i=0;i<evi.size();i++)
        {
            node.val=evi.get(i);
            node=node.next;
        }
        return head;
    }
}