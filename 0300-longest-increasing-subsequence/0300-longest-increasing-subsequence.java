class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] prev=new int[nums.length+1];
        int[] curr=new int[nums.length+1];
        Arrays.fill(prev,0);
        Arrays.fill(curr,0);
        
        for(int ind=nums.length-1;ind>=0;ind--)
        {
            for(int pi=ind-1;pi>=-1;pi--)
            {
                int len=0+prev[pi+1];
                if(pi==-1 || nums[ind]>nums[pi])
                {
                    len=Math.max(len,1+prev[ind+1]);
                }
                curr[pi+1]=len;
            }
            prev=curr;
        }
        return prev[-1+1];
    }
    public int function(int ind,int pi,int[] nums,int[][] dp)
    {
        if(ind==nums.length)
        {
            return 0;
        }
        if(dp[ind][pi+1]!=-1)
        {
            return dp[ind][pi+1];
        }
        int len=0+function(ind+1,pi,nums,dp);
        if(pi==-1 || nums[ind]>nums[pi])
        {
            len=Math.max(len,1+function(ind+1,ind,nums,dp));
        }
        return dp[ind][pi+1]=len;
    }
}