class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int low=0;
        int high=nums.length-1;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==nums[mid+1])
            {
                mid=mid-1;
            }
            if((mid-low+1)%2!=0)
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return nums[low];
    }
}