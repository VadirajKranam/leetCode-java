class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],0);
        }
        dp[n][0]=0;
        dp[n][1]=0;
        for(int i=n-1;i>=0;i--)
        {
            for(int buy=0;buy<=1;buy++)
            {
                int profit=Integer.MIN_VALUE;
                if(buy==1)
                {
                    profit=Math.max((-prices[i]+dp[i+1][0]),(0+dp[i+1][1]));
                }
                else
                {
                    profit=Math.max((prices[i]+dp[i+1][1]),(0+dp[i+1][0]));
                }
                dp[i][buy]=profit;
            }
        }
        return Math.max(dp[0][1],dp[1][1]);
    }
}




