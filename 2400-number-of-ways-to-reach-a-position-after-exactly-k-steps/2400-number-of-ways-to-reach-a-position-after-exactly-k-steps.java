class Solution {
    public int numberOfWays(int sp, int ep, int k) {
            int[][] dp=new int[3000][k+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(sp,ep,k,sp,dp)%1000000007;
    }
    public int function(int sp,int ep,int k,int p,int[][] dp)
    {
        if(k==0 && p==ep)
        {
            return 1;
        }
        if(k==0)
        {
            return 0;
        }
        if(dp[p+1000][k]!=-1)
        {
            return dp[p+1000][k]%1000000007;
        }
        return dp[p+1000][k]=function(sp,ep,k-1,p-1,dp)%1000000007+function(sp,ep,k-1,p+1,dp)%1000000007;
        
    }
}