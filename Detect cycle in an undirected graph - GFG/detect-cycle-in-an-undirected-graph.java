//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair{
    int f,s;
    Pair(int f,int s)
    {
        this.f=f;
        this.s=s;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis=new int[V];
        Arrays.fill(vis,0);
      
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                if(vis[adj.get(i).get(j)]==0)
                {
                    if(detect(adj.get(i).get(j),adj,vis))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean detect(int src,ArrayList<ArrayList<Integer>> adj,int[] vis)
    {
        vis[src]=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty())
        {
            int node=q.peek().f;
            int parent=q.peek().s;
            q.poll();
            for(int an : adj.get(node))
            {
                if(vis[an]==0)
                {
                    vis[an]=1;
                    q.offer(new Pair(an,node));
                }
                else if(parent!=an)
                {
                    return true;
                }
            }
        }
        return false;
    }
}









