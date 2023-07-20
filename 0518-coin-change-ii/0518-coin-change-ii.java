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
        if(i==coins.length)
        {
            if(amount==0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[i][amount]!=-1)
        {
            return dp[i][amount];
        }
        int notPick=function(i+1,coins,amount,dp);
        int pick=0;
        if(coins[i]<=amount)
        {
            pick=function(i,coins,amount-coins[i],dp);
        }
        return dp[i][amount]=pick+notPick;
    }
}