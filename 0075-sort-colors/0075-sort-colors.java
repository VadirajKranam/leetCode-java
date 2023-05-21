class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=0,k=nums.length-1;
        while(j<=k)
        {
            if(nums[j]==0)
            {
                swap(i,j,nums);
                i++;
                j++;
            }
            else if(nums[j]==2)
            {
                swap(j,k,nums);
                k--;
            }
            else
            {
                j++;
            }
        }
    }
    public void swap(int i,int j,int[] nums)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}