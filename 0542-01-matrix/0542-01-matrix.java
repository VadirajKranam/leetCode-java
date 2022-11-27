class Pair{
    int r,c,s;
    Pair(int r,int c,int s)
    {
        this.r=r;
        this.c=c;
        this.s=s;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] vis=new int[mat.length][mat[0].length];
        int[][] ans=new int[mat.length][mat[0].length];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j]=1;
                    q.offer(new Pair(i,j,0));
                }
                else
                {
                    vis[i][j]=0;
                }
            }
        }
        int[] dr={-1,0,+1,0};
        int[] dc={0,+1,0,-1};
        while(!q.isEmpty())
        {
            int nrow=q.peek().r;
            int ncol=q.peek().c;
            int steps=q.peek().s;
            q.poll();
            ans[nrow][ncol]=steps;
            for(int i=0;i<4;i++)
            {
                int r=nrow+dr[i];
                int c=ncol+dc[i];
                if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && vis[r][c]==0)
                {
                    vis[r][c]=1;
                    q.offer(new Pair(r,c,steps+1));
                }
            }
        }
        return ans;
    }
}