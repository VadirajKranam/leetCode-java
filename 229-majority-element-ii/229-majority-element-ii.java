class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<Integer>();
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
            if(set.getValue()>nums.length/3)
            {
                ans.add(set.getKey());
            }
        }
        return ans;
    }
}