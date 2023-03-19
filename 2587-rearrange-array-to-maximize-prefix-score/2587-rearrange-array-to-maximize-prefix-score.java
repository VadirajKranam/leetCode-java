class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
       if(nums[nums.length-1]==0)
       {
           return 0;
       }
        long sum=0;
        int i=nums.length-1;
        while(i>=0)
        {
            sum+=(long)nums[i--];
            if(sum<=0)
            {
                return nums.length-i-2;
            }
        }
        return nums.length;
    }
}