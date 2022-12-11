class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        int i=nums.length-1;
        int j=nums.length-k;
        while(j>=0)
        {
            min=Math.min(min,nums[i]-nums[j]);
            j--;
            i--;
        }
        return min;
    }
}