class Solution {
    public int findTargetSumWays(int[] nums, int target) {
       return function(0,nums,target,0);
    }
    public int function(int i,int[] nums,int target,int res)
    {
        if(i==nums.length)
        {
            if(res==target)
            {
                return 1;
            }
            return 0;
        }
        int c1=function(i+1,nums,target,res+nums[i]);
        int c2=function(i+1,nums,target,res-nums[i]);
        return c1+c2;
    }
}