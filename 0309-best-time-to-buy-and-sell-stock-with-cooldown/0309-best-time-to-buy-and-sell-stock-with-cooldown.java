class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length][2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return function(0,prices,1,dp);
    }
    int function(int ind,int[] prices,int buy,int[][] dp)
    {
        if(ind>=prices.length)
        {
            return 0;
        }
        if(dp[ind][buy]!=-1)
        {
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((-prices[ind]+function(ind+1,prices,0,dp)),function(ind+1,prices,1,dp));
        }
        else
        {
            profit=Math.max((prices[ind]+function(ind+2,prices,1,dp)),function(ind+1,prices,0,dp));
        }
        return dp[ind][buy]=profit;
    }
}