class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            h.put(nums[i],0);
        }
        for(int i=0;i<nums.length;i++)
        {
            h.put(nums[i],h.get(nums[i])+1);
        }
        for(Map.Entry<Integer,Integer> set:h.entrySet())
        {
            if(set.getValue()>nums.length/2)
            {
                return set.getKey();
            }
        }
        return -1;
    }
}