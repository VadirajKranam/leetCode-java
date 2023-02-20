//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
       Queue<Pair> q=new LinkedList<>();
       q.offer(new Pair(start,0));
       int[] dist=new int[100000];
      
       Arrays.fill(dist,Integer.MAX_VALUE);
        dist[start]=0;
       while(!q.isEmpty())
       {
           int node=q.peek().a;
           int dis=q.peek().b;
           q.poll();
           for(int i=0;i<arr.length;i++)
           {
               int adjNode=(node*arr[i])%100000;
               if(dist[adjNode]>dis+1)
               {
                   dist[adjNode]=dis+1;
                   if(adjNode==end){
                       return dis+1;
                   }
                   q.offer(new Pair(adjNode,dis+1));
               }
           }
       }
      
           return -1;
       
    }
}
