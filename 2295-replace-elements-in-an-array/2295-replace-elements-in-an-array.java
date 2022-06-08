class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
         HashMap<Integer, Integer> h1=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            h1.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++)
        {
            int index=h1.get(operations[i][0]);
            nums[index]=operations[i][1];
            h1.remove(operations[i][0]);
            h1.put(nums[index],index);
        }
        return nums;
    }
}