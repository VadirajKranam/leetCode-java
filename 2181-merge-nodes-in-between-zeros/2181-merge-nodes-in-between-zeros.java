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
    public ListNode mergeNodes(ListNode head) {
       ArrayList<Integer> ans=new ArrayList<>();
       ListNode t=head;
       ArrayList<Integer> arr=new ArrayList<>();
       
        while(t!=null)
        {
            arr.add(t.val);
            t=t.next;
        }
        //ans.add(0);
        int j=1;
        int sum=0;
        while(j<arr.size())
        {
            if(arr.get(j)==0)
            {
                ans.add(sum);
                sum=0;
            }
            else
            {
                sum+=arr.get(j);
            }
            j++;
        }
        if(ans.size()==0)
        {
            return null;
        }
        ListNode h=new ListNode(ans.get(0));
        ListNode t1=h;
        for(int i=1;i<ans.size();i++)
        {
            ListNode node=new ListNode(ans.get(i));
            node.next=null;
            t1.next=node;
            t1=t1.next;
        }
        return h;
    }
}