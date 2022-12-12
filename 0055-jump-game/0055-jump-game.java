class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
        {
            return true;
        }
       int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return function(0,nums,dp);
    }
    public boolean function(int ind,int[] nums,int[] dp)
    {
        if(ind==nums.length-1)
        {
            return true;
        }
        if(ind>=nums.length)
        {
            return false;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind]==1;
        }
        for(int i=1;i<=nums[ind];i++)
        {
            if(function(ind+i,nums,dp))
            {
                dp[ind]=1;
                return true;
            }
        }
        
        dp[ind]=0;
        return false;
    }
}