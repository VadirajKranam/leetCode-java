class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return function(0,nums,target);
    }
    public int function(int i,int[] nums,int sum)
    {
        if(i==nums.length-1)
        {
            if(nums[i]+sum==0 && nums[i]-sum==0)
            {
                return 2;
            }
            if(nums[i]+sum==0 || nums[i]-sum==0)
            {
                return 1;
            }
             return 0;
        }
        int plus=function(i+1,nums,sum+nums[i]);
        int minus=function(i+1,nums,sum-nums[i]);
        return plus+minus;
    }
}