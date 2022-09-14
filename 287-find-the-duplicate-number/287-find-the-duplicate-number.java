class Solution {
    public int findDuplicate(int[] nums) {
        int[] f=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            if(f[nums[i]]==0)
            {
                f[nums[i]]++;
            }
            else
            {
                return nums[i];
            }
        }
        return -1;
    }
}