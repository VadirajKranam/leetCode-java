class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return function(0,nums,target);
    }
    public int function(int i,int[] nums,int target)
    {
        if(i==nums.length-1)
        {
            if(target+nums[i]==0 && target-nums[i]==0)
            {
                return 2;
            }
            if(target-nums[i]==0 || target+nums[i]==0)
            {
                return 1;
            }
            return 0;
        }
        int plus=function(i+1,nums,target+nums[i]);
        int minus=function(i+1,nums,target-nums[i]);
        return plus+minus;
    }
}