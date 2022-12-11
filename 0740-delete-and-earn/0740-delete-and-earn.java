class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=10001;
        int[] hash=new int[n];
        Arrays.fill(hash,0);
        for(int num:nums)
        {
            hash[num]+=num;
        }
        return robHouse(hash);
    }
    public int robHouse(int[] hash)
    {
        int[] dp=new int[hash.length+1];
        Arrays.fill(dp,-1);
        return function(0,hash,dp);
    }
    public int function(int ind,int[] hash,int[] dp)
    {
        if(ind>=hash.length)
        {
            return 0;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        int take=hash[ind]+function(ind+2,hash,dp);
        int notTake=function(ind+1,hash,dp);
        return dp[ind]=Math.max(take,notTake);
    }
}