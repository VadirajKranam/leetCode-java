class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int s=target-nums[i];
            if(h.containsKey(s))
            {
                return new int[]{h.get(s),i};
            }
            h.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}