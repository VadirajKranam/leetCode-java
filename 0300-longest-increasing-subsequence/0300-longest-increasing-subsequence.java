class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length+1][nums.length+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],0);
        }
        for(int ind=nums.length-1;ind>=0;ind--)
        {
            for(int pi=ind-1;pi>=-1;pi--)
            {
                int len=0+dp[ind+1][pi+1];
                if(pi==-1 || nums[ind]>nums[pi])
                {
                    len=Math.max(len,1+dp[ind+1][ind+1]);
                }
                dp[ind][pi+1]=len;
            }
        }
        return dp[0][-1+1];
    }
    public int function(int ind,int pi,int[] nums,int[][] dp)
    {
        if(ind==nums.length)
        {
            return 0;
        }
        if(dp[ind][pi+1]!=-1)
        {
            return dp[ind][pi+1];
        }
        int len=0+function(ind+1,pi,nums,dp);
        if(pi==-1 || nums[ind]>nums[pi])
        {
            len=Math.max(len,1+function(ind+1,ind,nums,dp));
        }
        return dp[ind][pi+1]=len;
    }
}