//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
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
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
       List<Integer> ans=new ArrayList<Integer>();
       int[] dist=new int[n+1];
       Arrays.fill(dist,Integer.MAX_VALUE);
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
       for(int i=0;i<=n;i++)
       {
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++)
       {
           adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
           adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
       }
       PriorityQueue<Pair> pq=new PriorityQueue<Pair>((x,y)->x.b-y.b);
       int[] parent=new int[n+1];
       for(int i=0;i<parent.length;i++)
       {
           parent[i]=i;
       }
       pq.offer(new Pair(1,0));
       while(!pq.isEmpty())
       {
           int node=pq.peek().a;
           int dis=pq.peek().b;
           pq.poll();
           for(int i=0;i<adj.get(node).size();i++)
           {
               int adjNode=adj.get(node).get(i).a;
               int ew=adj.get(node).get(i).b;
               if(dis+ew<dist[adjNode])
               {
                   dist[adjNode]=dis+ew;
                   parent[adjNode]=node;
                   pq.offer(new Pair(adjNode,dist[adjNode]));
               }
           }
       }
       if(dist[n]==Integer.MAX_VALUE)
       {
           
               ans.add(-1);
           
           return ans;
       }
       ans.add(n);
       int par=parent[n];
       while(par!=1){
           
           ans.add(par);
          //System.out.println(par);
           par=parent[par];
           
       }
      Collections.reverse(ans);
       ans.add(0,1);
       return ans;
    }
}