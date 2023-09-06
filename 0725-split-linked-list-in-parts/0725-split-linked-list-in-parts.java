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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=0;
        ListNode t=head;
        while(t!=null)
        {
            len++;
            t=t.next;
        }
       int part=len/k;
        int extra=len%k;
        t=head;
        ListNode[] ans=new ListNode[k];
        int pt=0;
        while(t!=null)
        {
            ans[pt++]=t;
            int cl=part-1+((extra-->0)?1:0);
            for(int i=0;i<cl;i++)
            {
                t=t.next;
            }
            ListNode cur=t.next;
            t.next=null;
            t=cur;
        }
        return ans;
    }
}