class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] count=new int[nums.length];
        int[] dp=new int[nums.length];
        Arrays.fill(count,1);
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && 1+dp[j]>dp[i])
                {
                    dp[i]=dp[j]+1;
                    count[i]=count[j];
                }
                else if(nums[i]>nums[j] && 1+dp[j]==dp[i])
                {
                    count[i]+=count[j];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        int ans=0;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]==maxi)
            {
                ans+=count[i];
            }
        }
        return ans;
    }
}