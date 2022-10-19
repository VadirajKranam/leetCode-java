class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp=new int[grid.length][grid[0].length];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return function(grid.length-1,grid[0].length-1,grid,dp);
    }
    public int function(int m,int n,int[][] grid,int[][] dp)
    {
        if(m==0 && n==0)
        {
            return grid[0][0];
        }
        if(m<0 || n<0)
        {
            return 9999999;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        int up=grid[m][n]+function(m-1,n,grid,dp);
        int down=grid[m][n]+function(m,n-1,grid,dp);
        return dp[m][n]=Math.min(up,down);
    }
}