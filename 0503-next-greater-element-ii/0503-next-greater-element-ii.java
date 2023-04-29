class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int j=(i+1)%nums.length;
            int max=-1;
            while(j!=i)
            {
                if(nums[j]>nums[i])
                {
                    max=nums[j];
                    break;
                }
                j=(j+1)%nums.length;
            }
            ans[i]=max;
        }
        return ans;
    }
}