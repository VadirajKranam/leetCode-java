class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        int ans=function(coins.length-1,coins,amount,dp);
        if(ans==9999999)
        {
            return -1;
        }
        return ans;
    }
    public int function(int ind,int[] coins,int sum,int[][] dp)
    {
        if(ind==0)
        {
            return sum%coins[ind]==0?sum/coins[ind]:9999999;
        }
        if(dp[ind][sum]!=-1)
        {
            return dp[ind][sum];
        }
        int notPick=function(ind-1,coins,sum,dp);
        int pick=Integer.MAX_VALUE;
        if(coins[ind]<=sum)
        {
            pick=1+function(ind,coins,sum-coins[ind],dp);
        }
        return dp[ind][sum]=Math.min(notPick,pick);
    }
}