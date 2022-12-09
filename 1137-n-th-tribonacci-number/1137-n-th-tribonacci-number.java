class Solution {
    public int tribonacci(int n) {
        if(n<=1)
        {
            return n;
        }
        int[] dp=new int[n+2];
        Arrays.fill(dp,-1);
        return function(n,dp);
    }
    public int function(int n,int[] dp)
    {
        if(n==0)
        {
            return 0;
        }
        if(n>=1 && n<=2)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        return dp[n]=function(n-1,dp)+function(n-2,dp)+function(n-3,dp);
    }
}