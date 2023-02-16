//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class trio{
    int a,b,c;
    trio(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class pair{
    int a;
    int b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
       ArrayList<ArrayList<pair>> adj=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           adj.add(new ArrayList<>());
       }
       
       for(int i=0;i<flights.length;i++)
       {
           adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
       }
       Queue<trio> q=new LinkedList<>();
       q.add(new trio(0,src,0));
       int[] dist=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[src]=0;
       while(!q.isEmpty())
       {
           trio it=q.peek();
           q.remove();
           int stops=it.a;
           int node=it.b;
           int dis=it.c;
           if(stops>k)
           {
               continue;
           }
           for(pair iter:adj.get(node))
           {
               int adjNode=iter.a;
               int edw=iter.b;
               if((dis+edw)<dist[adjNode] && stops<=k)
               {
                   dist[adjNode]=dis+edw;
                   q.add(new trio(stops+1,adjNode,dist[adjNode]));
               }
           }
      
       }
      
       if(dist[dst]==Integer.MAX_VALUE)
       {
           return -1;
       }
       return dist[dst];
}
}






