class Solution {
    public int maxCoins(int[] nums) {
        int[] bals=new int[nums.length+2];
        bals[0]=1;
        bals[nums.length+1]=1;
        for(int i=1;i<=nums.length;i++)
        {
            bals[i]=nums[i-1];
        }
        int[][] dp=new int[bals.length+1][bals.length+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,0);
        }
        for(int i=nums.length;i>=1;i--)
        {
            for(int j=1;j<=nums.length;j++)
            {
                if(i>j)
                {
                    continue;
                }
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++)
                {
                    int cost=bals[i-1]*bals[k]*bals[j+1]+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(max,cost);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][nums.length];
    }
    public int function(int i,int j,int[] nums,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int max=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int cost=nums[i-1]*nums[k]*nums[j+1]+function(i,k-1,nums,dp)+function(k+1,j,nums,dp);
            max=Math.max(max,cost);
        }
        return dp[i][j]=max;
    }
}