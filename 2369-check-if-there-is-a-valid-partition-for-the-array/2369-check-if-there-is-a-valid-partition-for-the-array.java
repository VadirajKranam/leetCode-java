class Solution {
    public boolean validPartition(int[] nums) {
       int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return function(0,nums,dp);
    }
    public boolean function(int i,int[] nums,int[] dp)
    {
        if(i==nums.length)
        {
            return true;
        }
        if(dp[i]!=-1)
        {
            return dp[i]==1;
        }
        dp[i]=0;
        if(i+1<nums.length && nums[i]==nums[i+1])
        {
            if(function(i+2,nums,dp))
            {
                dp[i]=1;
            }
        }
        if(i+2<nums.length && nums[i]==nums[i+1] && nums[i+1]==nums[i+2])
        {
            if(function(i+3,nums,dp))
            {
                dp[i]=1;
            }
        }
         if(i+2<nums.length && nums[i+1]-nums[i]==1 && nums[i+2]-nums[i+1]==1)
        {
            if(function(i+3,nums,dp))
            {
                dp[i]=1;
            }
        }
        return dp[i]==1;
    }
}