class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp=new int[prices.length+1][2];
        for(int[] d:dp)
        {Arrays.fill(d,-1);}
        return function(0,prices,dp,1);
    }
    public int function(int ind,int[] prices,int[][] dp,int canBuy)
    {
        if(ind>=prices.length)
        {
            return 0;
        }
        if(dp[ind][canBuy]!=-1)
        {
            return dp[ind][canBuy];
        }
        int profit=0;
        if(canBuy==1)
        {
            profit=Math.max((-prices[ind]+function(ind+1,prices,dp,0)),function(ind+1,prices,dp,canBuy));
        }
        else
        {
            profit=Math.max((prices[ind]+function(ind+2,prices,dp,1)),function(ind+1,prices,dp,0));
        }
        return dp[ind][canBuy]=profit;
    }
}