class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp=new int[prices.length+1][2][k+1];
        for(int i=0;i<=prices.length;i++)
        {
            for(int j=0;j<2;j++)
            {
                Arrays.fill(dp[i][j],0);
            }
        }
        for(int ind=prices.length-1;ind>=0;ind--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                for(int cap=1;cap<=k;cap++)
                {
                    int profit=Integer.MIN_VALUE;
                    if(buy==1)
                    {
                        profit=Math.max((-prices[ind]+dp[ind+1][0][cap]),dp[ind+1][1][cap]);
                    }
                    else
                    {
                        profit=Math.max((prices[ind]+dp[ind+1][1][cap-1]),dp[ind+1][0][cap]);
                    }
                    dp[ind][buy][cap]=profit;
                }
            }
        }
      return   dp[0][1][k];
    }
    public int function(int ind,int[] prices,int buy,int k,int[][][] dp)
    {
        if(k==0)
        {
            return 0;
        }
        if(ind==prices.length)
        {
            return 0;
        }
        if(dp[ind][buy][k]!=Integer.MIN_VALUE)
        {
            return dp[ind][buy][k];
        }
        int profit=Integer.MIN_VALUE;
        if(buy==1)
        {
           profit=Math.max((-prices[ind]+function(ind+1,prices,0,k,dp)),(0+function(ind+1,prices,1,k,dp))); 
        }
        else
        {
            profit=Math.max((prices[ind]+function(ind+1,prices,1,k-1,dp)),(0+function(ind+1,prices,0,k,dp)));
        }
        return dp[ind][buy][k]=profit;
    }
}