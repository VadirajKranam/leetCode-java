class Solution {
    public long countPairs(int n, int[][] edges) {
        int[] vis=new int[n];
        Arrays.fill(vis,-1);
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
        long count=0;
        ArrayList<Long> arr=new ArrayList<>();
        long prev=0;
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==-1)
            {
               long visited=dfs(i,adj,vis,0);
              count+=(n-(visited+1)-prev)*(visited+1);
                prev+=visited+1;
            }            
        }
        
        return count;
    }
    public long dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,long count)
    {
        if(vis[node]!=-1)
        {
            return count;
        }
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==-1){
              count=dfs(adj.get(node).get(i),adj,vis,count+1);
            }
        }
        return count;
    }
}