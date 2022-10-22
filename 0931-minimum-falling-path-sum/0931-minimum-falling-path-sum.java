class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int[][] dp=new int[matrix.length][matrix[0].length];
         int m=matrix.length;
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
    public static int function(int m,int n,int[][] mat,int[][] dp)
    {
        if(m>=mat.length || n>=mat[0].length || n<0)
        {
            return 999999;
        }
        if(m==mat.length-1)
        {
            return mat[m][n];
        }
        if(dp[m][n]!=Integer.MAX_VALUE)
        {
            return dp[m][n];
        }
        int down=mat[m][n]+function(m+1,n,mat,dp);
        int dleft=mat[m][n]+function(m+1,n-1,mat,dp);
        int dright=mat[m][n]+function(m+1,n+1,mat,dp);
        return dp[m][n]=Math.min(down,Math.min(dleft,dright));
    }
}