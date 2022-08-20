class Solution {
    public void rotate(int[][] matrix) {
        int[][] ans=new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                ans[j][i]=matrix[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=matrix[i].length-1;j>=0;j--)
            {
                matrix[i][j]=ans[i][j];
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length/2;j++)
            {
                int t=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[i].length-j-1];
                matrix[i][matrix[i].length-j-1]=t;
            }
        }
    }
}