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
        if(ind>=nums.length)
        {
            return false;
        }
        if(ind==nums.length-1)
        {
            dp[ind]=1;
            return true;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind]==1;
        }
        int check=0;
        for(int i=1;i<=nums[ind];i++)
        {
            if(function(ind+i,nums,dp))
            {
                check=1;
                break;
            }
        }
        dp[ind]=check;
        return dp[ind]==1;
    }
}