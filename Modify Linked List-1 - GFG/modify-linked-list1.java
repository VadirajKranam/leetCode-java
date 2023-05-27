//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
    }
}
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int n=Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            Node head=new Node(Integer.parseInt(s[0]));
            Node copy=head;
            for(int i=1;i<n;i++){
                Node temp=new Node(Integer.parseInt(s[i]));
                copy.next=temp;
                copy=copy.next;
            }
            Solution ob=new Solution();
            Node ans=ob.modifyTheList(head);
            while(ans!=null){
                out.print(ans.data+" ");
                ans=ans.next;
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static Node modifyTheList(Node head)
    {
       ArrayList<Integer> fh=new ArrayList<>();
       ArrayList<Integer> sh=new ArrayList<>();
       int len=0;
       Node t=head;
       while(t!=null)
       {
           t=t.next;
           len++;
       }
       if(len==1)
       {
           return head;
       }
       t=head;
       int c=0;
       while(c!=len/2)
       {
           fh.add(t.data);
           t=t.next;
           c++;
       }
       if(len%2==1)
       {
           t=t.next;
       }
       while(t!=null)
       {
           sh.add(t.data);
           t=t.next;
       }
       ArrayList<Integer> temp=new ArrayList<>(fh);
       for(int i=0;i<fh.size();i++)
       {
           fh.set(i,sh.get(sh.size()-i-1)-fh.get(i));
       }
       sh=new ArrayList<>(temp);
       Collections.reverse(sh);
       t=head;
       for(int i=0;i<fh.size();i++)
       {
           t.data=fh.get(i);
           t=t.next;
       }
       if(len%2==1)
       {
           t=t.next;
       }
       for(int i=0;i<sh.size();i++)
       {
           t.data=sh.get(i);
           t=t.next;
       }
       return head;
    }
}