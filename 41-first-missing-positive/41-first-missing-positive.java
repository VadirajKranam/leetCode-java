class Solution {
    public int firstMissingPositive(int[] nums) {
     HashMap<Integer, Integer> h1=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            h1.put(nums[i],i);
        }
        int missing=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>missing)
            {
                missing=nums[i];
            }
        }
        for(int i=1;i<=missing;i++)
        {
            if(!(h1.containsKey(i)) && i<missing)
            {
                missing=i;
            }
        }if(h1.containsKey(missing))
        {
            missing++;
        }
        if(missing<=0)
        {
            return 1;
        }
        return missing;
    }
}