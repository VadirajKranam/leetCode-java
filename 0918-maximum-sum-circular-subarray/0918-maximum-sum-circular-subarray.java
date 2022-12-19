class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int nonCircularSum=function(nums);
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            nums[i]=-nums[i];
        }
        int circularMinSum=function(nums);
        int circularSum=sum+circularMinSum;
        if(circularSum==0)
        {
            return nonCircularSum;
        }
        return Math.max(nonCircularSum,circularSum);
    }
    public int function(int[] nums)
    {
        int maxSum=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(sum<0)
            {
                sum=0;
            }
            sum+=nums[i];
            maxSum=Math.max(sum,maxSum);
        }
        return maxSum;
    }
}