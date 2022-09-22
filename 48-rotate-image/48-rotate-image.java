class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix[i].length;j++)
            {
               int t=matrix[i][j];
               matrix[i][j]=matrix[j][i];
               matrix[j][i]=t;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            int l=matrix[i].length;
            for(int j=0;j<l/2;j++)
            {
                int t=matrix[i][l-j-1];
                matrix[i][l-j-1]=matrix[i][j];
                matrix[i][j]=t;
            }
        }
    }
}