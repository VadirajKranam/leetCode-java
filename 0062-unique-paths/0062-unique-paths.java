class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return function(m-1,n-1,dp);
    }
    public int function(int m,int n,int[][] dp)
    {
        if(m==0 && n==0)
        {
            return 1;
        }
        if(m<0 || n<0)
        {
            return 0;
        }
        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        int up=function(m,n-1,dp);
        int down=function(m-1,n,dp);
        return dp[m][n]=up+down;
    }
}