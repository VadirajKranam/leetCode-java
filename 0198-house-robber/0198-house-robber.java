class Solution {
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return subSum(nums,nums.length-1,dp);  
    }
    public int subSum(int[] nums,int index,int[] dp)
    {
        if(index==0)
        {
            return nums[index];
        }
        if(index<0)
        {
            return 0;
        }
        if(dp[index]!=-1)
        {
            return dp[index];
        }
        int pick=nums[index]+subSum(nums,index-2,dp);
        int notPick=subSum(nums,index-1,dp);
        return dp[index]=Math.max(pick,notPick);
    }
}