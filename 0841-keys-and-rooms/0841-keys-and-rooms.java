class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] vis=new int[rooms.size()];
        Arrays.fill(vis,0);
        dfs(0,rooms,vis);
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                return false;
            }
        }
        return true;
    }
    public void dfs(int i,List<List<Integer>> r,int[] vis)
    {
        if(vis[i]==1)
        {
            return;
        }
        vis[i]=1;
        for(int j=0;j<r.get(i).size();j++)
        {
            dfs(r.get(i).get(j),r,vis);
        }
    }
}