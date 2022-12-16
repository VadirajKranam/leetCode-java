class Solution {
    public int minimumAverageDifference(int[] n) {
        long[] nums=new long[n.length];
        for(int i=0;i<n.length;i++)
        {
            nums[i]=(long)(n[i]);
        }
      long sum=0;
        long min=Long.MAX_VALUE;
        long leftSum=0;
        long rightSum=0;
        for(long num:nums)
        {
            sum+=num;
        }
        int ans=0;
        for(int i=0;i<nums.length;i++)
        {
            leftSum+=nums[i];
            rightSum=sum-leftSum;
            long first=leftSum/(long)(i+1);
            long sec=0;
            if(nums.length-i-1!=0)
            {
                sec=rightSum/(long)(nums.length-i-1);
            }
            long check=Math.abs(first-sec);
            if(check<min)
            {
                min=check;
                ans=i;
            }
        }
        return ans;
    }
}