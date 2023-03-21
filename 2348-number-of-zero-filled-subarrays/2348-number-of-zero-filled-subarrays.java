class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long num=0;
       
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                count=count+(num*(num+1))/2;
                num=0;
            }
            else 
            {
                num++;
            }
        }
        return count=count+(num*(num+1))/2;
    }
}