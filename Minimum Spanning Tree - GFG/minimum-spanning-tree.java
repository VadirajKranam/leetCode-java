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
class Edge implements Comparable<Edge>{
    int src,dest,weight;
    Edge(int src,int dest,int weight)
    {
        this.src=src;
        this.dest=dest;
        this.weight=weight;
    }
    public int compareTo(Edge compareEdge)
    {
        return this.weight-compareEdge.weight;
    }
};
class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class DisjointSet{
   List<Integer> rank=new ArrayList<>();
   List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
   DisjointSet(int n){
       for(int i=0;i<=n;i++){
           rank.add(0);
           parent.add(i);
           size.add(1);
       }
   }
   public int findUPar(int node){
       if(node==parent.get(node))
       {
           return node;
       }
       int ulp=findUPar(parent.get(node));
       parent.set(node,ulp);
       return parent.get(node);
   }
   public void unionByRank(int u,int v){
       int ulp_u=findUPar(u);
       int ulp_v=findUPar(v);
       if(ulp_u==ulp_v)
       {
           return;
       }
       else if(rank.get(ulp_u)<rank.get(ulp_v)){
           parent.set(ulp_u,ulp_v);
       }
       else if(rank.get(ulp_u)>rank.get(ulp_v)){
           parent.set(ulp_v,ulp_u);
       }
       else{
           parent.set(ulp_v,ulp_u);
           rank.set(ulp_u,rank.get(ulp_u)+1);
       }
   }
    public void unionBySize(int u,int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
        }
    }
};
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	   List<Edge> edges1=new ArrayList<Edge>();
	   ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
	   for(int i=0;i<V;i++)
	   {
	       adj.add(new ArrayList<>());
	   }
	   for(int i=0;i<edges.length;i++)
	   {
	       adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	       //adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	   }
	   for(int i=0;i<V;i++)
	   {
	       for(int j=0;j<adj.get(i).size();j++){
	           int adjNode=adj.get(i).get(j).a;
	           int wt=adj.get(i).get(j).b;
	           int node=i;
	           Edge temp=new Edge(i,adjNode,wt);
	           edges1.add(temp);
	       }
	   }
	   DisjointSet ds=new DisjointSet(V);
	   Collections.sort(edges1);
	   int mstWt=0;
	   for(int i=0;i<edges1.size();i++){
	       int wt=edges1.get(i).weight;
	       int u=edges1.get(i).src;
	       int v=edges1.get(i).dest;
	       if(ds.findUPar(u)!=ds.findUPar(v))
	       {
	           mstWt+=wt;
	           ds.unionBySize(u,v);
	       }
	   }
	   return mstWt;
	}
	
}