class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            m.put(nums[i],m.getOrDefault(nums[i],0)+1);
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!m.containsKey(nums[i]))
            {
                continue;
            }
            int inCount=m.get(nums[i]);
            while(m.get(nums[i])-inCount<=1 && inCount>0)
            {
                ans.add(nums[i]);
                inCount--;
            }
            m.remove(nums[i]);
        }
        for(int i=0;i<ans.size();i++)
        {
            nums[i]=ans.get(i);
        }
        return ans.size();
    }
}