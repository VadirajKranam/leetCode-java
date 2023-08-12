class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
       int ans=Integer.MAX_VALUE;
        int[][] dp=new int[grid.length+1][grid[0].length+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        for(int i=0;i<grid[0].length;i++)
        {
            ans=Math.min(ans,function(0,i,grid,moveCost,dp));
            for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        }
        return ans;
    }
    public int function(int i,int j,int[][] grid,int[][] mc,int[][] dp)
    {
        if(i==grid.length-1)
        {
            return grid[i][j];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int ans=Integer.MAX_VALUE;
        for(int k=0;k<grid[0].length;k++)
        {
            ans=Math.min(ans,grid[i][j]+mc[grid[i][j]][k]+function(i+1,k,grid,mc,dp));
        }
        return dp[i][j]=ans;
    }
}