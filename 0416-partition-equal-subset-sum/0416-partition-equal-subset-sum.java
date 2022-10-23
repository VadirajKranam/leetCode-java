class Solution {
    public boolean canPartition(int[] nums) {
       int totalSum=0;
        for(int i=0;i<nums.length;i++)
        {
            totalSum+=nums[i];
        }
        int target=totalSum/2;
        if(totalSum%2==1)
        {
            return false;
        }
        int[][] dp=new int[nums.length][target+1];
        for(int row[]:dp)
        {
            Arrays.fill(row,-1);
        }
        return function(nums.length-1,nums,target,dp);
    }
    public boolean function(int ind,int[] nums,int target,int[][] dp)
    {
        if(target==0)
        {
            return true;
        }
        if(ind==0)
        {
            return target-nums[ind]==0;
        }
        if(dp[ind][target]!=-1)
        {
            return dp[ind][target]==1?true:false;
        }
        boolean notTake=function(ind-1,nums,target,dp);
        boolean Take=false;
        if(nums[ind]<=target)
        {
            Take=function(ind-1,nums,target-nums[ind],dp);
        }
        dp[ind][target]=notTake||Take?1:0;
        return notTake||Take;
    }
}