class Solution {
    public void solve(char[][] board) {
     for(int i=0;i<board.length;i++)
     {
         for(int j=0;j<board[i].length;j++)
         {
             if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1)
             {
                 if(board[i][j]=='O')
                 {
                     dfs(i,j,board);
                 }
             }
         }
     }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='1')
                {
                    board[i][j]='O';
                }
                else if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
            }
        }
        
    }
    public void dfs(int i,int j,char[][] board)
    {
        if(i<0 || j<0 || i>=board.length || j>=board[i].length)
        {
            return;
        }
        if(board[i][j]=='X' || board[i][j]=='1')
        {
            return;
        }
        board[i][j]='1';
        dfs(i-1,j,board);
        dfs(i+1,j,board);
        dfs(i,j+1,board);
        dfs(i,j-1,board);
    }
}