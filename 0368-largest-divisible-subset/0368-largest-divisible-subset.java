class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<hash.length;i++)
        {
            hash[i]=i;
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int pre=0;pre<i;pre++)
            {
                if(nums[i]%nums[pre]==0 && 1+dp[pre]>dp[i])
                {
                    dp[i]=dp[pre]+1;
                    hash[i]=pre;
                }
            }
        }
        int lastIndex=-1;
        int maxi=-1;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                lastIndex=i;
            }
        }
        ans.add(nums[lastIndex]);
        while(hash[lastIndex]!=lastIndex)
        {
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
            
        }
        return ans;
    }
}