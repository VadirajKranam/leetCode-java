class Solution {
    public int jump(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return function(nums,0,dp);
    }
    public int function(int[] nums,int ind,int[] dp)
    {
        if(ind>=nums.length)
        {
            return 9999999;
        }
        if(ind==nums.length-1)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int j=1;
        int ans=9999999;
        if(nums[ind]==0)
        {
            return 99999999;
        }
        while(j<=nums[ind])
        {
            ans=Math.min(ans,1+function(nums,ind+j,dp));
            j++;
        }
      return  dp[ind]=ans;
    }
}