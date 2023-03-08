class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int s=0,e=matrix[0].length-1;
        while(s<matrix.length && e>=0)
        {
            if(matrix[s][e]==target)
            {
                return true;
            }
            else if(matrix[s][e]<target)
            {
                s++;
            }
            else
            {
                e--;
            }
        }
        return false;
    }
}