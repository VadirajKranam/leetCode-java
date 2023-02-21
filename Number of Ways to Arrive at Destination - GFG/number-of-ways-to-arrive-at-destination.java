//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
       ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
       for(int i=0;i<n;i++)
       {
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<roads.size();i++)
       {
           adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
           adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
       }
       PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.b-y.b);
       int[] dist=new int[n];
       int[] ways=new int[n];
       Arrays.fill(dist,Integer.MAX_VALUE);
       dist[0]=0;
       Arrays.fill(ways,0);
       ways[0]=1;
       pq.offer(new Pair(0,0));
       while(!pq.isEmpty())
       {
           int node=pq.peek().a;
           int dis=pq.peek().b;
           pq.poll();
           for(int i=0;i<adj.get(node).size();i++)
           {
               int adjNode=adj.get(node).get(i).a;
               int wt=adj.get(node).get(i).b;
               if(dis+wt==dist[adjNode])
               {
                   ways[adjNode]+=ways[node];
               }
              else  if(dis+wt<dist[adjNode])
               {
                   dist[adjNode]=dis+wt;
                   pq.offer(new Pair(adjNode,dis+wt));
                   ways[adjNode]=ways[node];
               }
           }
       }
       return ways[n-1];
    }
}
