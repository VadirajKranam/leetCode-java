class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp=new int[values.length][values.length];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,values.length-1,values,dp);
    }
    public int function(int i,int j,int[] values,int[][] dp)
    {
        if(j-i==1)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++)
        {
            int steps=values[i]*values[k]*values[j]+function(i,k,values,dp)+function(k,j,values,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=min;
    }
}