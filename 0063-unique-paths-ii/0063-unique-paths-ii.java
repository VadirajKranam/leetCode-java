class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return findAnswer(m-1,n-1,obstacleGrid,dp);
    }
    public int findAnswer(int m,int n,int[][] obstacleGrid,int[][] dp)
    {
        if(m<0 || n<0)
        {
            return 0;
        }
        if(obstacleGrid[m][n]==1)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        if(m==0 && n==0)
        {
            return 1;
        }
        int up=findAnswer(m-1,n,obstacleGrid,dp);
        int left=findAnswer(m,n-1,obstacleGrid,dp);
        return dp[m][n]=(up+left)%2000000000;
    }
}