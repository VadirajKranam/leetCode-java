class Solution {
    public int findMin(int[] nums) {
        int l=0,h=nums.length-1;
        while(l<=h)
        {
            int m=l+(h-l)/2;
            if(nums[h]==nums[m])
            {
                h--;
            }
            else if(nums[m]>nums[h])
            {
                l=m+1;
            }
            else
            {
                h=m;
            }
        }
        return nums[l];
    }
}