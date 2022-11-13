class Solution {
    public int maxProfit(int[] prices) {
     int[][][] dp=new int[prices.length+1][2][3];
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
                for(int cap=1;cap<=2;cap++)
                {
                  int profit=Integer.MIN_VALUE;
                 if(buy==1)
                 {
                   profit=Math.max((-prices[ind]+dp[ind+1][0][cap]),(0+dp[ind+1][1][cap])); 
                 }
                 else
                 {
                   profit=Math.max((prices[ind]+dp[ind+1][1][cap-1]),(0+dp[ind+1][0][cap])); 
                 }
                  dp[ind][buy][cap]=profit;  
                }
            }
        }
        return dp[0][1][2];
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






