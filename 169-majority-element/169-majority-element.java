class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hs=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            hs.put(nums[i],0);
        }
        for(int i=0;i<nums.length;i++)
        {
            hs.put(nums[i],hs.get(nums[i])+1);
        }
        for(Map.Entry<Integer,Integer> m:hs.entrySet())
        {
            if(m.getValue()>nums.length/2)
            {
                return m.getKey();
            }
        }
        return -1;
    }
}