class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        int max=1;
        Arrays.fill(dp,1);
        for(int ind=0;ind<nums.length;ind++)
        {
            for(int prev=0;prev<ind;prev++)
            {
                if(nums[prev]<nums[ind])
                {
                    dp[ind]=Math.max(1+dp[prev],dp[ind]);
                }
            }
            max=Math.max(max,dp[ind]);
        }
        return max;
    }
}