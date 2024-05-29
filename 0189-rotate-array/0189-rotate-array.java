class Solution {
    public void rotate(int[] nums, int k) {
        k=k%nums.length;
        reverse(0,nums.length-k-1,nums);
        reverse(nums.length-k,nums.length-1,nums);
        reverse(0,nums.length-1,nums);
    }
    public void reverse(int l,int h,int[] nums)
    {
        while(l<=h)
        {
            swap(nums,l,h);
            l++;
            h--;
        }
    }
    public void swap(int[] nums,int i,int j)
    {
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}