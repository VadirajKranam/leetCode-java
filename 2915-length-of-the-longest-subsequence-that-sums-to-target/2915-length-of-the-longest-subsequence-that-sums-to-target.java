class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
     int[][] dp=new int[nums.size()+1][target+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        int ans= function(0,nums,target,dp);
        return ans<0?-1:ans;
    }
    public int function(int i,List<Integer> nums,int target,int[][] dp)
    {
        if(i>=nums.size())
        {
            if(target==0)
            {
                return 0;
            }
            return -999999999;
        }
        if(dp[i][target]!=-1)
        {
            return dp[i][target];
        }
        int take=-999999999;
        if(target-nums.get(i)>=0)
        {
            take=1+function(i+1,nums,target-nums.get(i),dp);
        }
        int notTake=function(i+1,nums,target,dp);
        return dp[i][target]=Math.max(take,notTake);
    }
}