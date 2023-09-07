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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ArrayList<Integer> arr=new ArrayList<>();
        ListNode t=head;
        while(t!=null)
        {
            arr.add(t.val);
            t=t.next;
        }
        int s=left;
        int e=right;
        // for(int i=0;i<arr.size();i++)
        // {
        //     if(arr.get(i)==left)
        //     {
        //         s=i;
        //     }
        //     else if(arr.get(i)==right)
        //     {
        //         e=i;
        //     }
        // }
        while(s<=e)
        {
            int te=arr.get(s-1);
            arr.set(s-1,arr.get(e-1));
            arr.set(e-1,te);
            s++;
            e--;
        }
    t=head;
        for(int i=0;i<arr.size();i++)
        {
            t.val=arr.get(i);
            t=t.next;
        }
        return head;
    }
}