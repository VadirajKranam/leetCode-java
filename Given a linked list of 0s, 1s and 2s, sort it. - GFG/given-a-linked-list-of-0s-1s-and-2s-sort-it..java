//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int len=0;
        Node node=head;
        while(node!=null)
        {
            node=node.next;
            len++;
        }
        int[] a=new int[len];
        int i=0;
        node=head;
        while(node!=null)
        {
            a[i++]=node.data;
            node=node.next;
        }
        int l=0,m=0,h=a.length-1;
        while(m<=h)
        {
            if(a[m]==0)
            {
                int t=a[l];
                a[l]=a[m];
                a[m]=t;
                l++;
                m++;
            }
             else if(a[m]==1)
             {
                 m++;
             }
             else
             {
                 int t=a[h];
                 a[h]=a[m];
                 a[m]=t;
                 h--;
             }
        }
       node=head;
      for(int j=0;j<a.length;j++)
      {
          node.data=a[j];
          node=node.next;
      }
      return head;
    }
}


