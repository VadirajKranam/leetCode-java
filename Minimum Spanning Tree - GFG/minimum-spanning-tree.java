//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int a,b;
    Pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	   PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.a-y.a);
	   int sum=0;
	   ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	   for(int i=0;i<V;i++)
	   {
	       adj.add(new ArrayList<>());
	   }
	   for(int i=0;i<edges.length;i++)
	   {
	       adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	       adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	   }
	   int[] vis=new int[V];
	   Arrays.fill(vis,0);
	   // {wt,node}
	   pq.offer(new Pair(0,0));
	   while(!pq.isEmpty())
	   {
	       int node=pq.peek().b;
	       int wt=pq.peek().a;
	       pq.poll();
	       if(vis[node]==1)
	       {
	           continue;
	       }
	       vis[node]=1;
	       sum+=wt;
	       for(int i=0;i<adj.get(node).size();i++)
	       {
	           int adjNode=adj.get(node).get(i).a;
	           int ew=adj.get(node).get(i).b;
	           if(vis[adjNode]==0)
	           {
	               pq.offer(new Pair(ew,adjNode));
	           }
	       }
	   }
	   return sum;
	}
}