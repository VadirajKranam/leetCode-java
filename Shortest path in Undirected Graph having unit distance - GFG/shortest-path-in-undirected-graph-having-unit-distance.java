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
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Pair{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int w=1;
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(src,0));
        int[] dist=new int[n];
        Arrays.fill(dist,9999999);
        dist[src]=0;
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int d=q.peek().second;
            vis[node]=1;
            q.poll();
            for(int i=0;i<adj.get(node).size();i++)
            {
               int v=adj.get(node).get(i).first;
               int w=adj.get(node).get(i).second;
               if((d+w)<dist[v])
               {
                   dist[v]=d+w;
               }
               if(vis[v]==-1)
               {
                   q.offer(new Pair(v,dist[v]));
               }
            }
        }
        for(int i=0;i<dist.length;i++)
        {
            if(dist[i]==9999999)
            {
                dist[i]=-1;
            }
        }
        return dist;
    }
}