//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
class Solution
{
    Node compute(Node head)
    {
        if(head==null)
        {
            return null;
        }
      ArrayList<Integer> a1=new ArrayList<>();
      Node t=head;
      while(t!=null)
      {
        a1.add(t.data);
        t=t.next;
      }
      Collections.reverse(a1);
      ArrayList<Integer> a2=new ArrayList<>();
       int max=a1.get(0);
       a2.add(max);
       for(int i=1;i<a1.size();i++)
       {
           if(a1.get(i)>=max)
           {
               a2.add(a1.get(i));
           }
         max=Math.max(max,a1.get(i));
       }
       Collections.reverse(a2);
       Node ans=new Node(a2.get(0));
        t=ans;
       for(int i=1;i<a2.size();i++)
       {
           Node newNode=new Node(a2.get(i));
           t.next=newNode;
           t=t.next;
           t.next=null;
       }
       return ans;
    }
}
  