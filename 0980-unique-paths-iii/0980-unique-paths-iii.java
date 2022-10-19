class Solution {
    public int uniquePathsIII(int[][] grid) {
        int sx=0,sy=0;
        int zero=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    sx=i;
                    sy=j;

                }
                else if(grid[i][j]==0)
                {
                    zero++;
                }
            }
        }
      return dfs(sx,sy,grid,zero);
    }
    public static int dfs(int sx,int sy,int[][] grid,int zero)
    {
        if(sx<0 || sy<0 || sx>=grid.length || sy>=grid[0].length || grid[sx][sy]==-1)
        {
            return 0;
        }
        if(grid[sx][sy]==2)
        {
          return zero==-1?1:0;
        }
        grid[sx][sy]=-1;
        zero--;
        int totalPaths=dfs(sx+1,sy,grid,zero)+
                       dfs(sx-1,sy,grid,zero)+
                       dfs(sx,sy+1,grid,zero)+
                       dfs(sx,sy-1,grid,zero);
        grid[sx][sy]=0;
        zero++;
        return totalPaths;
    }
}