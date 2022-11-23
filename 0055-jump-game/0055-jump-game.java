class Solution {
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return function(0,nums,dp)==1;
    }
    public int function(int ind,int[] nums,int[] dp)
    {
        if(ind==nums.length-1)
        {
            return 1;
        }
        if(ind>=nums.length)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int ans=0;
        for(int i=1;i<=nums[ind];i++)
        {
            int k=function(ind+i,nums,dp);
            if(k==1)
            {
                ans=k;
                break;
            }
        }
        return dp[ind]=ans;
    }
}