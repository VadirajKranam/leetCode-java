class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            if(e.getValue()>nums.length/3)
            {
                ans.add(e.getKey());
            }
        }
        return ans;
    }
}