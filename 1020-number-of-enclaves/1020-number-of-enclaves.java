class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] t=new int[grid.length][grid[0].length];
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[0].length;j++)
            {
                t[i][j]=grid[i][j];
            }
        }
        for(int j=0;j<t[0].length;j++)
        {
            dfs(0,j,t);
        }
        for(int i=0;i<t.length;i++)
        {
            dfs(i,t[0].length-1,t);
        }
        for(int j=0;j<t[0].length;j++)
        {
            dfs(t.length-1,j,t);
        }
        for(int i=0;i<t.length;i++)
        {
            dfs(i,0,t);
        }
        int count=0;
        for(int i=0;i<t.length;i++)
        {
            for(int j=0;j<t[0].length;j++)
            {
                if(t[i][j]==1)
                {
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i,int j,int[][] t)
    {
        if(i<0 || j<0 || i>=t.length || j>=t[0].length || t[i][j]==0)
        {
            return;
        }
        t[i][j]=0;
        dfs(i-1,j,t);
        dfs(i,j+1,t);
        dfs(i+1,j,t);
        dfs(i,j-1,t);
    }
}