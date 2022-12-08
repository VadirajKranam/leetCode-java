class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int[] vis=new int[graph.length];
        int[] pv=new int[graph.length];
        Arrays.fill(vis,0);
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                dfs(i,vis,pv,graph);
            }
        }
        for(int i=0;i<pv.length;i++)
        {
            if(pv[i]==0)
            {
                ans.add(i);
            }
        }
        return ans;
    }
    public boolean dfs(int node,int[] vis,int[] pv,int[][] graph)
    {
        vis[node]=1;
        pv[node]=1;
        for(int i=0;i<graph[node].length;i++)
        {
            if(vis[graph[node][i]]==0)
            {
                if(dfs(graph[node][i],vis,pv,graph)==true)
                {
                    return true;
                }
            }
            else if(pv[graph[node][i]]==1)
            {
                return true;
            }
        }
        pv[node]=0;
        return false;
    }
}