class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<paths.length;i++)
        {
           adj.get(paths[i][0]).add(paths[i][1]);
           adj.get(paths[i][1]).add(paths[i][0]);
        }
        int[] vis=new int[n+1];
        Arrays.fill(vis,0);
        boolean temp=fillIt(adj,vis);
        int[] ans=new int[vis.length-1];
        for(int i=0;i<vis.length-1;i++)
        {
            ans[i]=vis[i+1];
        }
        return ans;
    }
    public boolean fillIt(ArrayList<ArrayList<Integer>> adj,int[] vis)
    {
        int node=-1;
        for(int i=1;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                node=i;
                break;
            }
        }
        if(node==-1)
        {
            return true;
        }
        for(int i=1;i<=4;i++)
        {
            if(isValid(adj,vis,i,node))
            {
                vis[node]=i;
                if(fillIt(adj,vis))
                {
                    return true;
                }
                else
                {
                    vis[node]=0;
                }
            }
        }
        return false;
    }
    public boolean isValid(ArrayList<ArrayList<Integer>> adj,int[] vis,int col,int node)
    {
        for(int i=0;i<adj.get(node).size();i++)
        {
            if(vis[adj.get(node).get(i)]==col)
            {
                return false;
            }
        }
        return true;
    }
}