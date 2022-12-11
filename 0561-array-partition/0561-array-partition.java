class Solution {
    public int arrayPairSum(int[] nums) {
        int i=0;
        int sum=0;
        Arrays.sort(nums);
        while(i<nums.length-1)
        {
            sum+=Math.min(nums[i],nums[i+1]);
            i+=2;
        }
        return sum;
    }
}