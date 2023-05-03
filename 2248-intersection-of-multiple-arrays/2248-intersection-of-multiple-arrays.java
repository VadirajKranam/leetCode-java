class Solution {
    public List<Integer> intersection(int[][] nums) {
       Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                m.put(nums[i][j],m.getOrDefault(nums[i][j],0)+1);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            if(e.getValue()==nums.length)
            {
                ans.add(e.getKey());
            }
        }
        Collections.sort(ans);
        return ans;
    }
}