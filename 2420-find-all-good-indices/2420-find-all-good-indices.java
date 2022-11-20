class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] dp1=new int[nums.length+1];
        int[] dp2=new int[nums.length+1];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>=nums[i])
            {
                dp1[i]=1+dp1[i-1];
            }
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<=nums[i+1])
            {
                dp2[i]=1+dp2[i+1];
            }
        }
        for(int i=k;i<nums.length-k;i++)
        {
            if(dp1[i-1]>=k && dp2[i+1]>=k)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}