class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int count=dynamic(n,dp);
        return count;
    }
    static int dynamic(int n,int[] dp)
    {
        if(n<=1)
        {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
       return  dp[n]=dynamic(n-1,dp)+dynamic(n-2,dp);
    }
}