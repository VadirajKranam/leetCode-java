//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
       ArrayList<Integer>[] a=new ArrayList[V];
       for(int i=0;i<a.length;i++)
       {
           a[i]=new ArrayList<>();
       }
       for(int i=0;i<V;i++)
       {
           for(int j=0;j<V;j++)
           {
               if(adj.get(i).get(j)==1 && i!=j)
               {
                   a[i].add(j);
                   a[j].add(i);
               }
           }
       }
       int[] vis=new int[V];
       Arrays.fill(vis,0);
       int count=0;
       for(int i=0;i<vis.length;i++)
       {
           if(vis[i]==0)
           {
               count++;
               dfs(i,a,vis);
           }
       }
       return count;
    }
    static void dfs(int node, ArrayList<Integer>[] a,int[] vis)
    {
        vis[node]=1;
        for(int i=0;i<a[node].size();i++)
        {
            if(vis[a[node].get(i)]==0){
            dfs(a[node].get(i),a,vis);
            }
        }
    }
};