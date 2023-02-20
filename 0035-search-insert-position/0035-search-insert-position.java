class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target)
        {
            return 0;
        }
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(mid-1>=0 && nums[mid-1]<target && nums[mid]>target)
            {
                return mid;
            }
            if(mid+1<nums.length && nums[mid]<target && nums[mid+1]>target)
            {
                return mid+1;
            }
            if(nums[mid]>target)
            {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return nums.length;
    }
}