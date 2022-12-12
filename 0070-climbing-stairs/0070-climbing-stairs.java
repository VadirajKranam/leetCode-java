class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return function(0,n,dp);
    }
    public int function(int i,int n,int[] dp)
    {
        if(i==n)
        {
            return 1;
        }
        if(i>n)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
       return dp[i]=function(i+1,n,dp)+function(i+2,n,dp);
    }
}