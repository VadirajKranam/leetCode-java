class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int len=0;
        int[] dp=new int[low+high];
        Arrays.fill(dp,-1);
        
        return function(low,high,zero,one,len,dp)%1000000007;
    }
    public int function(int l,int h,int z,int o,int len,int[] dp)
    {
        if(len>h)
        {
            return 0;
        }
        if(dp[len]!=-1)
        {
            return dp[len]%1000000007;
        }
        if(len>=l && len<=h)
        {
        return dp[len]=1+function(l,h,z,o,len+z,dp)%1000000007+function(l,h,z,o,len+o,dp)%1000000007;
        }
        return dp[len]=function(l,h,z,o,len+z,dp)%1000000007+function(l,h,z,o,len+o,dp)%1000000007;
    }
}