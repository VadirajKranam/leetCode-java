class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ans=new ArrayList<>();
        int r=matrix.length,c=matrix[0].length;
        int i,l=0,k=0;
        while(k<r && l<c)
        {
          for(i=l;i<c;i++)
          {
            ans.add(matrix[k][i]);
          }
            k++;
            for(i=k;i<r;i++)
            {
                ans.add(matrix[i][c-1]);
            }
            c--;
            if(k<r)
            {
                for(i=c-1;i>=l;i--)
                {
                    ans.add(matrix[r-1][i]);
                }
                r--;
            }
            if(l<c)
            {
                for(i=r-1;i>=k;i--)
                {
                    ans.add(matrix[i][l]);
                }
                l++;
            }
        }
        return ans;
    }
}