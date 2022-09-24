class Solution {
    public int findDuplicate(int[] nums) {
        int[] count=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            count[nums[i]]++;
        }
        for(int i=1;i<count.length;i++)
        {
            if(count[i]>=2)
            {
                return i;
            }
        }
        return -1;
    }
}