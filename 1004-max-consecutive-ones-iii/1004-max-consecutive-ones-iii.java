class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0,zero=0,ans=0;
        for(int right=0;right<nums.length;right++)
        {
            if(nums[right]==0)
            {
                zero++;
            }
            if(zero>k)
            {
                if(nums[left]==0)
                {
                    zero--;
                }
                left++;
            }
            if(zero<=k)
            {
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans;
    }
}