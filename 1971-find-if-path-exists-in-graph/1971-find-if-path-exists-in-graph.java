class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<adj.length;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<edges.length;i++)
        {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        int[] vis=new int[n];
        Arrays.fill(vis,0);
        dfs(source,destination,adj,vis);
        if(vis[destination]==1)
        {
            return true;
        }
        return false;
    }
    public void dfs(int i,int des,ArrayList<Integer>[] adj,int[] vis)
    {
        if(i==des && vis[des]!=1)
        {
            vis[des]=1;
            return;
        }
        if(vis[i]==1)
        {
            return;
        }
        vis[i]=1;
        for(int j=0;j<adj[i].size();j++)
        {
            dfs(adj[i].get(j),des,adj,vis);
        }
    }
}