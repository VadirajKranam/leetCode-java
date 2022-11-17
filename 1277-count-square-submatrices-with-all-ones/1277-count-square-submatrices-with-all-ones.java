class Solution {
    public int countSquares(int[][] matrix) {
        int[][] dp=new int[matrix.length][matrix[0].length];
        for(int j=0;j<matrix[0].length;j++)
        {
            dp[0][j]=matrix[0][j];
        }
        for(int i=0;i<matrix.length;i++)
        {
            dp[i][0]=matrix[i][0];
        }
        for(int i=1;i<matrix.length;i++)
        {
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==1)
                {
                int s=Math.min(dp[i-1][j],dp[i-1][j-1]);
                dp[i][j]=Math.min(s,dp[i][j-1])+1;
                }
                else
                {
                    dp[i][j]=0;
                }
            }
        }
        int sum=0;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}