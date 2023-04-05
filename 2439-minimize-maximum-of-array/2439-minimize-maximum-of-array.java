class Solution {
    public boolean check(int mid,int[] nums)
    {
        long sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>(long)mid*(i+1))
            {
                return false;
            }
        }
        return true;
    }
    public int minimizeArrayValue(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,nums[i]);
        }
        int left=0,right=max;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(check(mid,nums))
            {
                right=mid;
            }
            else
            {
                left=mid+1;
            }
        }
        return left;
    }
}