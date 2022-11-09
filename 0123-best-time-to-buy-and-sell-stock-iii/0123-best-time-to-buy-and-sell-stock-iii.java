class Solution {
    public int maxProfit(int[] prices) {
     int[][][] dp=new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                Arrays.fill(dp[i][j],Integer.MIN_VALUE);
            }
        }
        return function(0,1,2,prices,dp);
    }
    public int function(int ind,int buy,int cap,int[] prices,int[][][] dp)
    {
        if(cap==0)
        {
            return 0;
        }
        if(ind==prices.length)
        {
            return 0;
        }
        if(dp[ind][buy][cap]!=Integer.MIN_VALUE)
        {
            return dp[ind][buy][cap];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==1)
        {
          profit=Math.max((-prices[ind]+function(ind+1,0,cap,prices,dp)),(0+function(ind+1,1,cap,prices,dp)));  
        }
        else
        {
             profit=Math.max((prices[ind]+function(ind+1,1,cap-1,prices,dp)),(0+function(ind+1,0,cap,prices,dp))); 
        }
        return dp[ind][buy][cap]=profit;
    }
}





