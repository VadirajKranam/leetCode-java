class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=grid[i].length-1;j>=0;j--)
            {
                if(grid[i][j]>=0)
                {
                    break;
                }
                count++;
            }
        }
        return count;
    }
}