class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        int ans1=function(0,cost,dp);
        Arrays.fill(dp,-1);
        int ans2=function(1,cost,dp);
        return Math.min(ans1,ans2);
    }
    public int function(int i,int[] cost,int[] dp)
    {
        if(i>cost.length)
        {
            return 99999999;
        }
        if(i==cost.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        return dp[i]=cost[i]+Math.min(function(i+1,cost,dp),function(i+2,cost,dp));
    }
}