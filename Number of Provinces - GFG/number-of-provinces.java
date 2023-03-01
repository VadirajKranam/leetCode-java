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
      int[] vis=new int[V];
      int count=0;
      Arrays.fill(vis,0);
      for(int i=0;i<vis.length;i++)
      {
          if(vis[i]==0)
          {
              count++;
              dfs(i,adj,vis);
          }
      }
      return count;
    }
  public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis)
  {
      if(vis[node]==1)
      {
          return;
      }
      vis[node]=1;
      for(int i=0;i<adj.get(node).size();i++)
      {
          if(adj.get(node).get(i)==1)
          {
              dfs(i,adj,vis);
          }
      }
  }
};