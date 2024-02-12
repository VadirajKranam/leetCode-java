class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,coins,amount,dp);
    }
    public int function(int i,int[] coins,int amount,int[][] dp)
    {
        if(amount<0 || i==coins.length)
        {
            return 0;
        }
        if(amount==0)
        {
            return 1;
        }
        if(dp[i][amount]!=-1)
        {
            return dp[i][amount];
        }
        int take=0;
        if(coins[i]<=amount)
        {
            take=function(i,coins,amount-coins[i],dp);
        }
        int notTake=function(i+1,coins,amount,dp);
        return dp[i][amount]=take+notTake;
    }
}