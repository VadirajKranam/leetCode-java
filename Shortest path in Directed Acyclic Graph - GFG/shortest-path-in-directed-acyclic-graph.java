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
    int f,s;
    Pair(int f,int s)
    {
        this.f=f;
        this.s=s;
    }
}
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++)
		{
		    adj.add(new ArrayList<>());
		}
		for(int i=0;i<edges.length;i++)
		{
		    int u=edges[i][0];
		    int v=edges[i][1];
		    int w=edges[i][2];
		    adj.get(u).add(new Pair(v,w));
		}
		int[] vis=new int[N];
		Arrays.fill(vis,-1);
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<vis.length;i++)
		{
		    if(vis[i]==-1)
		    {
		        dfs(i,adj,vis,s);
		    }
		}
		int[] dis=new int[N];
		Arrays.fill(dis,9999999);
		dis[0]=0;
		while(!s.isEmpty())
		{
		    int node=s.pop();
		    for(int i=0;i<adj.get(node).size();i++)
		    {
		        int v=adj.get(node).get(i).f;
		        int w=adj.get(node).get(i).s;
		        if((dis[node]+w)<dis[v])
		        {
		            dis[v]=dis[node]+w;
		        }
		    }
		}
		for(int i=0;i<dis.length;i++)
		{
		    if(dis[i]==9999999)
		    {
		        dis[i]=-1;
		    }
		}
		return dis;
	}
	public void dfs(int node,ArrayList<ArrayList<Pair>> adj,int[] vis,Stack<Integer> s)
	{
	    vis[node]=1;
	    for(int i=0;i<adj.get(node).size();i++)
	    {
	        if(vis[adj.get(node).get(i).f]==-1)
	        {
	            dfs(adj.get(node).get(i).f,adj,vis,s);
	        }
	    }
	    s.push(node);
	}
}