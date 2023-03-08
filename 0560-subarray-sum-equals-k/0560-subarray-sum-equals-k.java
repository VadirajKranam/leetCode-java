class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        Map<Integer,Integer> m=new HashMap<>();
        m.put(0,1);
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            
            sum+=nums[i];
            if(m.containsKey(sum-k))
            {
                count+=m.get(sum-k);
            }
            m.put(sum,m.getOrDefault(sum,0)+1);
        }
        return count;
    }
}