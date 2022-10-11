/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       ListNode temp=head;
       ListNode f=head;
        ListNode s=head;
        int length=0;
        while(s!=null && s.next!=null)
        {
            f=f.next;
            s=s.next.next;
            if(f==s)
            {
                length=cycleLength(temp);
                break;
            }
        }
        if(length==0)
        {
            return null;
        }
        f=head;
        s=head;
        while(length!=0)
        {
            s=s.next;
            length--;
        }
        while(f!=s)
        {
            f=f.next;
            s=s.next;
        }
        return f;
    }
    public static int cycleLength(ListNode head)
    {
          ListNode f=head;
        ListNode s=head;
        while(s!=null && s.next!=null)
        {
            f=f.next;
            s=s.next.next;
            if(f==s)
            {
                int length=0;
                ListNode temp=f;
                do{
                    temp=temp.next;
                    length++;
                }while(temp!=f);
                return length;
            }
        }
        return 0;
    }
}
