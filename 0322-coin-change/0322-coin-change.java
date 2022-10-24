class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,0);
        }
       for(int i=0;i<=amount;i++)
       {
           if(i%coins[0]==0)
           {
               dp[0][i]=i/coins[0];
           }
           else
           {
               dp[0][i]=9999999;
           }
       }
        for(int ind=1;ind<coins.length;ind++)
        {
            for(int target=0;target<=amount;target++)
            {
                int notPick=dp[ind-1][target];
                int pick=Integer.MAX_VALUE;
                if(coins[ind]<=target)
                {
                    pick=1+dp[ind][target-coins[ind]];
                }
                dp[ind][target]=Math.min(notPick,pick);
            }
        }
        if(dp[coins.length-1][amount]==9999999)
        {
            return -1;
        }
        return dp[coins.length-1][amount];
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