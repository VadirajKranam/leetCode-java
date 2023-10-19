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
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Pair{
    int node,level;
    Pair(int node,int level)
    {
        this.node=node;
        this.level=level;
    }
}
class Solution
{
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
       Queue<Pair> q=new LinkedList<>();
       //int level=0;
       int[] vis=new int[V];
       Arrays.fill(vis,-1);
       q.offer(new Pair(0,0));
       while(!q.isEmpty())
       {
           int node=q.peek().node;
           int level=q.peek().level;
           if(node==X)
           {
               return level;
           }
           q.poll();
           for(int i=0;i<adj.get(node).size();i++)
           {
               if(vis[adj.get(node).get(i)]==-1){
               q.offer(new Pair(adj.get(node).get(i),level+1));
               vis[adj.get(node).get(i)]=1;
               }
           }
       }
       return -1;
    }
}