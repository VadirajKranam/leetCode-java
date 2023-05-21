class Solution {
    public int shortestBridge(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int[][] vis=new int[grid.length][grid.length];
        for(int[] v:vis)
        {
            Arrays.fill(v,-1);
        }
        boolean found=false;
        for(int i=0;i<grid.length;i++)
        {
            if(found)
            {
                break;
            }
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    dfs(i,j,vis,q,grid);
                    found=true;
                    break;
                }
            }
        }
        int steps=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            int[] d1={-1,1,0,0};
            int[] d2={0,0,1,-1};
            while(size-->0)
            {
              
              for(int l=0;l<d1.length;l++)
              {
                 int i=q.peek()[0]+d1[l];
                 int j=q.peek()[1]+d2[l];
                  if(i>=0 && j>=0 && i<grid.length && j<grid.length && vis[i][j]!=1)
                  {
                      if(grid[i][j]==1)
                      {
                          return steps;
                      }
                      q.offer(new int[]{i,j});
                      vis[i][j]=1;
                  }   
              }
                q.poll();
            }
            steps++;
        }
        return steps;
    }
    public void dfs(int i,int j,int[][] vis,Queue<int[]> q,int[][] grid)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]==0 || vis[i][j]==1)
        {
            return;
        }
        vis[i][j]=1;
        q.offer(new int[]{i,j});
        dfs(i-1,j,vis,q,grid);
        dfs(i+1,j,vis,q,grid);
        dfs(i,j-1,vis,q,grid);
        dfs(i,j+1,vis,q,grid);
    }
}