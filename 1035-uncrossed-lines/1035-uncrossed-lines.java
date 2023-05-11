class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp=new int[nums1.length][nums2.length];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,0,nums1,nums2,dp);
    }
    public int function(int i,int j,int[] n1,int[] n2,int[][] dp)
    {
        if(i==n1.length|| j==n2.length)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(n1[i]==n2[j])
        {
            return 1+function(i+1,j+1,n1,n2,dp);
        }
        
        return dp[i][j]=Math.max(function(i+1,j,n1,n2,dp),function(i,j+1,n1,n2,dp));
    }
}