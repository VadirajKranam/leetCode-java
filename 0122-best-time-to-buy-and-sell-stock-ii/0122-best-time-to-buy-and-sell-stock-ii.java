class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],Integer.MIN_VALUE);
        }
        return function(0,1,prices,dp);
    }
    public int function(int ind,int buy,int[] prices,int[][] dp)
    {
        if(ind==prices.length)
        {
            return 0;
        }
        if(dp[ind][buy]!=Integer.MIN_VALUE)
        {
            return dp[ind][buy];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==1)
        {
            profit=Math.max((-prices[ind]+function(ind+1,0,prices,dp)),(0+function(ind+1,1,prices,dp)));
        }
        else
        {
          profit=Math.max((prices[ind]+function(ind+1,1,prices,dp)),(0+function(ind+1,0,prices,dp)));  
        }
        return dp[ind][buy]=profit;
    }
}