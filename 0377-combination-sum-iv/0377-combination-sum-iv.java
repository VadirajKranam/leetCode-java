class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[][] dp=new int[nums.length+1][target+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,nums,target,dp);
    }
    public int function(int i,int[] nums,int target,int[][] dp)
    {
        if(target==0)
        {
            return 1;
        }
        if(target<0 || i>=nums.length)
        {
            return 0;
        }
        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int pick=0;
        if(nums[i]<=target)
        {
            pick=function(0,nums,target-nums[i],dp);
        }
        int notPick=function(i+1,nums,target,dp);
        return dp[i][target]=pick+notPick;
    }
}