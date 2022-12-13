class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        int ans=99999999;
        for(int j=0;j<matrix[0].length;j++)
        {
            ans=Math.min(ans,function(0,j,matrix,dp));
            for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        }
        return ans;
        
    }
    public int function(int i,int j,int[][] matrix,int[][] dp)
    {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length)
        {
            return 99999999;
        }
        if(i==matrix.length-1)
        {
            return matrix[i][j];
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int min=99999999;
        min=Math.min(min,matrix[i][j]+function(i+1,j-1,matrix,dp));
        min=Math.min(min,matrix[i][j]+function(i+1,j,matrix,dp));
        min=Math.min(min,matrix[i][j]+function(i+1,j+1,matrix,dp));
        return dp[i][j]=min;
    }
}