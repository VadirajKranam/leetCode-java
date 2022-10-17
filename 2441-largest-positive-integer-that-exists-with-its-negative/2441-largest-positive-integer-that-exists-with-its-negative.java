class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<j)
        {
            if(nums[i]+nums[j]>0)
            {
                j--;
            }
            if(nums[i]+nums[j]<0)
            {
                i++;
            }
            else if(nums[i]+nums[j]==0)
            {
                return nums[j];
            }
        }
        return -1;
    }
}