class Solution {
    public void moveZeroes(int[] nums) {
        int[] t=new int[nums.length];
        int i=0;
        for(int j=0;j<nums.length;j++)
        {
            if(nums[j]!=0)
            {
                t[i++]=nums[j];
            }
        }
        while(i<t.length)
        {
            t[i++]=0;
        }
        for(int j=0;j<nums.length;j++)
        {
            nums[j]=t[j];
        }
    }
}