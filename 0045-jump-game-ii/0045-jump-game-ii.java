class Solution {
    public int jump(int[] nums) {
         int[] dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return function(0,nums,dp);
    }
    public int function(int ind,int[] nums,int[] dp)
    {
        if(ind==nums.length-1)
        {
            return 0;
        }
        if(ind>=nums.length)
        {
            return 99999999;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int min=99999999;
        for(int i=1;i<=nums[ind];i++)
        {
             min=Math.min(min,1+function(ind+i,nums,dp));
        }
        return dp[ind]=min;
    }
}