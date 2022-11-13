class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        for(int ind=0;ind<nums.length;ind++)
        {
            for(int prev=0;prev<ind;prev++)
            {
                if(nums[ind]>nums[prev])
                {
                    dp[ind]=Math.max(dp[ind],1+dp[prev]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<dp.length;i++)
        {
            max=Math.max(max,dp[i]);
        }
        return max;
        
    }
}