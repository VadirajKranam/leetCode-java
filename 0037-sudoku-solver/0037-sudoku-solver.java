class Solution {
    public void solveSudoku(char[][] board) {
        boolean ans=solve(board);
    }
    public boolean solve(char[][] board)
    {
        boolean noEmpty=false;
        int r=-1;
        int c=-1;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='.')
                {
                    r=i;
                    c=j;
                    noEmpty=true;
                    break;
                }
            }
            if(noEmpty)
            {
                break;
            }
        }
        if(!noEmpty)
        {
            return true;
        }
        for(char ch='1';ch<='9';ch++)
        {
            if(isValid(board,r,c,ch))
            {
                board[r][c]=ch;
                if(solve(board))
                {
                    return true;
                }
                board[r][c]='.';
            }
        }
        return false;
        
    }
    public boolean isValid(char[][] board,int r,int c,char ch)
    {
        for(int i=0;i<board.length;i++)
        {
            if(board[i][c]==ch)
            {
                return false;
            }
        }
        for(int i=0;i<board.length;i++)
        {
            if(board[r][i]==ch)
            {
                return false;
            }
        }
        int sqrt=(int)Math.sqrt(board.length);
        int sr=r-r%sqrt;
        int sc=c-c%sqrt;
        for(int i=sr;i<sr+sqrt;i++)
        {
            for(int j=sc;j<sc+sqrt;j++)
            {
                if(board[i][j]==ch)
                {
                    return false;
                }
            }
        }
        return true;
    }
}