class Solution {
    public int numIslands(char[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        for(int[] v:vis)
        {
            Arrays.fill(v,0);
        }
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                    count++;
                    dfs(i,j,grid,vis);
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,char[][] grid,int[][] vis)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==1 || grid[i][j]=='0')
        {
            return;
        }
        vis[i][j]=1;
        dfs(i-1,j,grid,vis);
        dfs(i,j+1,grid,vis);
        dfs(i+1,j,grid,vis);
        dfs(i,j-1,grid,vis);
    }
}