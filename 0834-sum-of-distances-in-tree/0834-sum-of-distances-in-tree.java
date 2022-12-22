class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
           adj.get(edges[i][0]).add(edges[i][1]);
           adj.get(edges[i][1]).add(edges[i][0]);
        }
       int[] ans=new int[n];
       int[] nodes=new int[n];
       ans[0]=dfs(0,adj,nodes,-1);
        Queue<Integer> q=new LinkedList<>();
        q.offer(0);
        boolean[] seen=new boolean[n];
        seen[0]=true;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                int curr=q.poll();
                for(int nei:adj.get(curr))
                {
                    if(!seen[nei])
                    {
                        seen[nei]=true;
                        ans[nei]=ans[curr]-nodes[nei]+(n-nodes[nei]);
                        q.offer(nei);
                    }
                }
            }
        }
        return ans;
    }
   public int dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] nodes,int parent)
   {
       int dist=0;
       nodes[node]=1;
       for(int nei:adj.get(node))
       {
           if(nei!=parent)
           {
               dist+=dfs(nei,adj,nodes,node);
               nodes[node]+=nodes[nei];
               dist+=nodes[nei];
           }
       }
       return dist;
   }
}