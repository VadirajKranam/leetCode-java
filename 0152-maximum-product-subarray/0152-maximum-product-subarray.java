class Solution {
    public int maxProduct(int[] nums) {
        int maxRight=nums[0];
        int maxLeft=nums[0];
        int prod=1;
        boolean z=false;
        for(int n:nums)
        {
            prod*=n;
            if(prod==0)
            {
                z=true;
                prod=1;
                continue;
            }
            maxLeft=Math.max(maxLeft,prod);
        }
        prod=1;
        for(int j=nums.length-1;j>=0;j--)
        {
            prod*=nums[j];
            if(prod==0)
            {
                z=true;
                prod=1;
                continue;
            }
            maxRight=Math.max(maxRight,prod);
        }
        if(z)
        {
            return Math.max(Math.max(maxRight,maxLeft),0);
        }
        return Math.max(maxRight,maxLeft);
    }
}