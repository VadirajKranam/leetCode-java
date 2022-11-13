class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans=new ArrayList<Integer>();
        Arrays.sort(nums);
        int[] dp=new int[nums.length];
        int[] hash=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            hash[i]=i;
        }
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && dp[i]<1+dp[j])
                {
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
        }
        int maxi=-1;
        int lastIndex=-1;
        for(int i=0;i<dp.length;i++)
        {
            if(dp[i]>maxi)
            {
                maxi=dp[i];
                lastIndex=i;
            }
        }
        ans.add(nums[lastIndex]);
        while(lastIndex!=hash[lastIndex])
        {
            lastIndex=hash[lastIndex];
            ans.add(nums[lastIndex]);
        }
        return ans;
    }
}