class Solution {
    public boolean canCross(int[] stones) {
         HashMap<Integer,Set<Integer>> dp=new HashMap<>();
        for(int i=0;i<stones.length;i++)
        {
            dp.put(stones[i],new HashSet<>());
        }
        dp.get(stones[0]).add(1);
        for(int val:stones)
        {
            for(int jump:dp.get(val))
            {
                if(jump!=0 && dp.containsKey(val+jump))
                {
                    dp.get(val+jump).add(jump-1);
                    dp.get(val+jump).add(jump);
                    dp.get(val+jump).add(jump+1);
                }
            }
        }
        return !dp.get(stones[stones.length-1]).isEmpty();
    }
}