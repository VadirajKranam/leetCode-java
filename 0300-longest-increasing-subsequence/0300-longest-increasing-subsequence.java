class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp=new int[nums.length][nums.length+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return function(0,-1,nums,dp);
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