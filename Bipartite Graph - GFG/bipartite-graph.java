//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
       int[] vis=new int[V];
       Arrays.fill(vis,-1);
       for(int i=0;i<vis.length;i++)
       {
           if(vis[i]==-1)
           {
               if(!check(i,V,adj,vis))
               {
                   return false;
               }
           }
       }
       return true;
    }
    public boolean check(int s,int V,ArrayList<ArrayList<Integer>>adj,int[] vis)
    {
         Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        vis[s]=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            int color=vis[node]==0?1:0;
            for(int i=0;i<adj.get(node).size();i++)
            {
                if(vis[adj.get(node).get(i)]==vis[node] && node!=adj.get(node).get(i))
                {
                    return false;
                }
                else if(vis[adj.get(node).get(i)]==-1)
                {
                    vis[adj.get(node).get(i)]=color;
                    q.offer(adj.get(node).get(i));
                }
               
            }
        }
        return true;
    }
}