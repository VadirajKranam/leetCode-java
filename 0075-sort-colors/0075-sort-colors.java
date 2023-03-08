class Solution {
    public void sortColors(int[] nums) {
        int low=0,high=nums.length-1,mid=0;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int t=nums[low];
                nums[low]=nums[mid];
                nums[mid]=t;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                int t=nums[mid];
                nums[mid]=nums[high];
                nums[high]=t;
                high--;
            }
        }
    }
}