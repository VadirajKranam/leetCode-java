class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0;
        int m=matrix[0].length;
        int n=matrix.length;
        int r=m*n-1;
       while(l<=r)
       {
           int mid=l+(r-l)/2;
           if(matrix[mid/m][mid%m]==target)
           {
               return true;
           }
           else if(matrix[mid/m][mid%m]<target)
           {
               l=mid+1;
           }
           else
           {
               r=mid-1;
           }
       }
        return false;
    }
}