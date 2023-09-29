class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncrease=true;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                isIncrease=false;
            }
        }
        if(isIncrease)
        {
            return true;
        }
        boolean isDecrease=true;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]<nums[i+1])
            {
                isDecrease=false;
            }
        }
        if(isDecrease)
        {
            return true;
        }
        return false;
    }
}