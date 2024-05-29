class Solution {
    public boolean check(int[] nums) {
        int pivot=-1;
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                pivot=i+1;
                break;
            }
        }
        if(pivot==-1)
        {
            return true;
        }
        for(int i=pivot;i>pivot-1;i=(i+1)%nums.length)
        {
            if(nums[i]>nums[(i+1)%nums.length])
            {
                return false;
            }
        }
        return true;
    }
}