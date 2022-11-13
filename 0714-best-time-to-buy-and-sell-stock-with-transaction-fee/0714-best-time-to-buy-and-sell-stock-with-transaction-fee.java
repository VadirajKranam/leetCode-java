class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp=new int[prices.length+1][2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],0);
        }
        for(int ind=prices.length-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit=Integer.MIN_VALUE;
                if(buy==1)
                {
                    profit=Math.max((-prices[ind]+dp[ind+1][0]),dp[ind+1][1]);
                }
                else
                {
                    profit=Math.max((prices[ind]+dp[ind+1][1]-fee),dp[ind+1][0]);
                }
                dp[ind][buy]=profit;
            }
        }
        return dp[0][1];
    }
    public int function(int ind,int[] prices,int buy,int fee,int[][] dp)
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
            profit=Math.max((-prices[ind]+function(ind+1,prices,0,fee,dp)),function(ind+1,prices,1,fee,dp));
        }
        else
        {
            profit=Math.max((prices[ind]-fee+function(ind+1,prices,1,fee,dp)),function(ind+1,prices,0,fee,dp));
        }
        return dp[ind][buy]=profit;
    }
}