class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=0)
            return 0;
        int prod=1;
        int i=0;
        int j=0;
        int count=0;
        while(j<nums.length)
        {
            prod*=nums[j];
            while(prod>=k && i<nums.length)
            {
                prod/=nums[i];
                i++;
            }
            if(prod<k){
            count+=(j-i+1);
            }
            j++;
        }
        return count;
    }
}