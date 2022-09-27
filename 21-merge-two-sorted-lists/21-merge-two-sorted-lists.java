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
        ListNode ans=null;
        if(list1==null)
        {
            return list2;
        }
        else if(list2==null)
        {
            return list1;
        }
        if((list1.val<=list2.val))
        {
            ans=new ListNode(list1.val);
            list1=list1.next;
        }
        else if(list2!=null)
        {
            ans=new ListNode(list2.val);
            list2=list2.next;
        }
        ListNode t=ans;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                ListNode n=new ListNode(list1.val);
                t.next=n;
                t=n;
                list1=list1.next;
            }
            else
            {
                ListNode n=new ListNode(list2.val);
                t.next=n;
                t=n;
                list2=list2.next;
            }
        }
        while(list1!=null)
        {
            ListNode n=new ListNode(list1.val);
                t.next=n;
                t=n;
            list1=list1.next;
        }
        while(list2!=null)
        {
             ListNode n=new ListNode(list2.val);
                t.next=n;
                t=n;
            list2=list2.next;
        }
        return ans;
    }
}