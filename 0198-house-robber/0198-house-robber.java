class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return function(nums,nums.length-1,dp);
    }
    public int function(int[] nums,int ind,int[] dp)
    {
        if(ind<0)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int pick=nums[ind]+function(nums,ind-2,dp);
        int notPick=function(nums,ind-1,dp);
        return dp[ind]=Math.max(pick,notPick);
    }
}