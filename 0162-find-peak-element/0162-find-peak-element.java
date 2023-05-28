class Solution {
    public int findPeakElement(int[] nums) {
        int low=0,high=nums.length-1;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(mid==0)
            {
                return nums[0]>=nums[1]?0:1;
            }
            if(mid==nums.length-1)
            {
                return nums[nums.length-1]>=nums[nums.length-2]?nums.length-1:nums.length-2;
            }
            else if(nums[mid]>=nums[mid-1] && nums[mid]>=nums[mid+1])
            {
               return mid;
            }
            else if(nums[mid]<nums[mid-1])
            {
                high=mid-1;
            }
            else
            {
                 low=mid+1;
            }
        }
        return low;
    }
}