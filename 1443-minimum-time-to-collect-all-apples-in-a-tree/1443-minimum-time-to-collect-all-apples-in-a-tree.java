class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        boolean[] vis=new boolean[n];
        Arrays.fill(vis,false);
        for(int i=0;i<edges.length;i++)
        {
                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);
        }
       return dfs(0,adj,vis,hasApple);
    }
   public int dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,List<Boolean> hasApple)
   {
       vis[node]=true;
       int time=0;
       for(int i=0;i<adj.get(node).size();i++)
       {
           if(!vis[adj.get(node).get(i)])
           {
               time+=dfs(adj.get(node).get(i),adj,vis,hasApple);
           }
       }
       if(node!=0 && (hasApple.get(node)||time>0))
       {
           time+=2;
       }
       return time;
   }
}