class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return function(n,dp);
    }
    public int function(int n,int[] dp)
    {
        if(n<0)
        {
            return 0;
        }
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
       return dp[n]=function(n-1,dp)+function(n-2,dp);
    }
}