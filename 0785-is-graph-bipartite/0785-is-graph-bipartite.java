class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] vis=new int[graph.length];
        Arrays.fill(vis,-1);
       for(int i=0;i<vis.length;i++)
       {
           if(vis[i]==-1)
           {
               if(!check(i,vis,graph))
               {
                   return false;
               }
           }
       }
        return true;
    }
    public boolean check(int s,int[] vis,int[][] graph)
    {
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        vis[s]=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            int color=vis[node]==0?1:0;
            for(int i=0;i<graph[node].length;i++)
            {
                if(vis[graph[node][i]]==vis[node] && node!=i)
                {
                    return false;
                }
                else if(vis[graph[node][i]]==-1)
                {
                    vis[graph[node][i]]=color;
                    q.offer(graph[node][i]);
                }
            }
        }
        return true;
    }
}