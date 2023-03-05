//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int c = sc.nextInt();
            int d = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.isBridge(V,list,c,d));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
      
        int cnt1=0;
        int[] vis=new int[V];
        Arrays.fill(vis,0);
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                cnt1++;
                dfs(i,adj,vis);
            }
        }
          adj.get(c).remove(Integer.valueOf(d));
          adj.get(d).remove(Integer.valueOf(c));
           Arrays.fill(vis,0);
           int cnt2=0;
           for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                cnt2++;
                dfs(i,adj,vis);
            }
        }
        if(cnt2==cnt1)
        {
            return 0;
        }
        return 1;
    }
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis)
    {
        vis[node]=1;
        for(Integer it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,adj,vis);
            }
        }
    }
}