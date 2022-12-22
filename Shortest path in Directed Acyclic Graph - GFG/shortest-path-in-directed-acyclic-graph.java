//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int n,w;
    Pair(int n,int w)
    {
        this.n=n;
        this.w=w;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
	     ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	     for(int i=0;i<N;i++)
	     {
	         adj.add(new ArrayList<>());
	     }
	     int[] vis=new int[N];
	     Arrays.fill(vis,-1);
	     Stack<Integer> s=new Stack<>();
	     for(int i=0;i<edges.length;i++)
	     {
	         int u=edges[i][0];
	         int v=edges[i][1];
	         int w=edges[i][2];
	         adj.get(u).add(new Pair(v,w));
	     }
	     for(int i=0;i<N;i++)
	     {
	         if(vis[i]==-1)
	         {
	             topoSort(i,adj,vis,s);
	         }
	     }
	     int[] dist=new int[N];
	     for(int i=0;i<dist.length;i++)
	     {
	         dist[i]=9999999;
	     }
	     dist[0]=0;
	     while(!s.isEmpty())
	     {
	         int node=s.pop();
	         for(int i=0;i<adj.get(node).size();i++)
	         {
	             int v=adj.get(node).get(i).n;
	             int w=adj.get(node).get(i).w;
	             if((dist[node]+w)<dist[v])
	             {
	                 dist[v]=dist[node]+w;
	             }
	         }
	     }
	     for(int i=0;i<N;i++)
	     {
	         if(dist[i]==9999999)
	         {
	             dist[i]=-1;
	         }
	     }
	     return dist;
	}
	public void topoSort(int node,ArrayList<ArrayList<Pair>> adj,int[] vis,Stack<Integer> s)
	{
	    vis[node]=1;
	    for(int i=0;i<adj.get(node).size();i++)
	    {
	        int v=adj.get(node).get(i).n;
	        if(vis[v]==-1)
	        {
	            topoSort(v,adj,vis,s);
	        }
	    }
	    s.push(node);
	}
}














