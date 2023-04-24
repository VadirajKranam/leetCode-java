//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                if(graph[i][j])
                {
                    adj.get(i).add(j);
                }
            }
        }
        int[] vis=new int[n];
        Arrays.fill(vis,0);
        boolean ans=fillIt(adj,vis,m);
        return ans;
    }
    public boolean fillIt(ArrayList<ArrayList<Integer>> adj,int[] vis,int m)
    {
        boolean allVisited=true;
        int node=-1;
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                node=i;
                break;
            }
        }
        if(node==-1)
        {
            return true;
        }
        for(int i=1;i<=m;i++)
        {
            if(isValid(adj,i,node,vis))
            {
                vis[node]=i;
                if(fillIt(adj,vis,m))
                {
                    return true;
                }
                else
                {
                    vis[node]=0;
                }
            }
        }
        return false;
    }
    public boolean isValid(ArrayList<ArrayList<Integer>> adj,int col,int node,int[] vis)
    {
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==col)
            {
                return false;
            }
        }
        return true;
    }
}