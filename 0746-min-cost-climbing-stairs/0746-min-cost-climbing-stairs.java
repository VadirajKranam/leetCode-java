class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int[] dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(function(0,cost,dp),function(1,cost,dp));
    }
    public int function(int i,int[] cost,int[] dp)
    {
        if(i>=cost.length)
        {
            return 0;
        }
        if(i==cost.length-1)
        {
            return cost[i];
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        return dp[i]=cost[i]+Math.min(function(i+1,cost,dp),function(i+2,cost,dp));
    }
}