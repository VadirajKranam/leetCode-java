class Solution {
    public int search(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e)
        {
            int m=s+(e-s)/2;
            if(nums[m]==target)
            {
                return m;
            }
            else if(nums[m]>target)
            {
                e=e-1;
            }
            else
            {
                s=s+1;
            }
        }
        return -1;
    }
}