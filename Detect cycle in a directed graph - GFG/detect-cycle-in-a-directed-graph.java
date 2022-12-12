//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
       int[] ind=new int[V];
       Arrays.fill(ind,0);
       for(int i=0;i<adj.size();i++)
       {
           for(int j=0;j<adj.get(i).size();j++)
           {
               ind[adj.get(i).get(j)]++;
           }
       }
       Queue<Integer> q=new LinkedList<>();
       for(int i=0;i<ind.length;i++)
       {
           if(ind[i]==0)
           {
               q.offer(i);
           }
       }
      int count=0;
       while(!q.isEmpty())
       {
           int node=q.poll();
           count++;
           for(int i=0;i<adj.get(node).size();i++)
           {
               ind[adj.get(node).get(i)]--;
               if(ind[adj.get(node).get(i)]==0)
               {
                   q.offer(adj.get(node).get(i));
               }
           }
       }
       if(count==V)
       {
           return false;
       }
       return true;
    }
}






