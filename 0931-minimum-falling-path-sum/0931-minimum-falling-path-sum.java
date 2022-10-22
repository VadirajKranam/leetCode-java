class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int[] row:dp)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++)
        {
            ans=Math.min(function(0,i,matrix,dp),ans);
           for(int[] row:dp)
           {
            Arrays.fill(row,Integer.MAX_VALUE);
           } 
        }
        return ans;
    }
    public int function(int m,int n,int[][] matrix,int[][] dp)
    {
        if(m>=matrix.length || n>=matrix[0].length || n<0)
        {
            return 9999999;
        }
        if(m==matrix.length-1)
        {
            return matrix[m][n];
        }
        if(dp[m][n]!=Integer.MAX_VALUE)
        {
            return dp[m][n];
        }
        int dleft=matrix[m][n]+function(m+1,n-1,matrix,dp);
        int d=matrix[m][n]+function(m+1,n,matrix,dp);
        int dright=matrix[m][n]+function(m+1,n+1,matrix,dp);
        return dp[m][n]=Math.min(d,Math.min(dleft,dright));
    }
}