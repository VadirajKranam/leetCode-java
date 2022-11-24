class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] im=new int[image.length][image[0].length];
        for(int i=0;i<image.length;i++)
        {
            for(int j=0;j<image[i].length;j++)
            {
                im[i][j]=image[i][j];
            }
        }
        int ini=im[sr][sc];
        dfs(sr,sc,im,color,ini);
        return im;
    }
    public void dfs(int i,int j,int[][] im,int c,int in)
    {
        if(i<0 || j<0 || i>=im.length || j>=im[0].length || im[i][j]!=in || im[i][j]==c)
        {
            return;
        }
        im[i][j]=c;
        dfs(i-1,j,im,c,in);
        dfs(i,j+1,im,c,in);
        dfs(i+1,j,im,c,in);
        dfs(i,j-1,im,c,in);
    }
}