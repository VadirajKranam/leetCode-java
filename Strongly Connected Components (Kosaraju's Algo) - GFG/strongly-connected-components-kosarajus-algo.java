//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis=new int[V];
        Arrays.fill(vis,0);
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,adj,st);
            }
        }
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++)
        {
            vis[i]=0;
            for(Integer it:adj.get(i))
            {
                adjT.get(it).add(i);
            }
        }
        int scc=0;
        while(!st.isEmpty())
        {
            int node=st.peek();
            st.pop();
            if(vis[node]==0)
            {
                dfs2(node,vis,adjT);
                scc++;
            }
        }
        return scc;
    }
    public void dfs(int node,int[] vis,ArrayList<ArrayList<Integer>> adj,Stack<Integer> st)
    {
        vis[node]=1;
        for(Integer it:adj.get(node))
        {
            if(vis[it]==0)
            {
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    public void dfs2(int node,int[] vis,ArrayList<ArrayList<Integer>> adjT)
    {
        vis[node]=1;
        for(int i=0;i<adjT.get(node).size();i++)
        {
            if(vis[adjT.get(node).get(i)]==0)
            {
                dfs2(adjT.get(node).get(i),vis,adjT);
            }
        }
    }
}
