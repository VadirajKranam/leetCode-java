class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] b:board)
        {
            Arrays.fill(b,'.');
        }
        List<List<String>> ans=new ArrayList<>();
        function(0,board,ans);
        return ans;
    }
    public void function(int col,char[][] board,List<List<String>> ans)
    {
        if(col==board.length)
        {
           List<String> a=new ArrayList<>();
            for(char[] b:board)
            {
                a.add(new String(b));
            }
            ans.add(a);
            return;
        }
        for(int row=0;row<board.length;row++)
        {
            if(validate(row,col,board))
            {
                board[row][col]='Q';
                function(col+1,board,ans);
                board[row][col]='.';
            }
        }
    }
    public boolean validate(int row,int col,char[][] board)
    {
        int dr=row,dc=col;
        //System.out.println(dr+" "+col);
        while(dr>=0 && dc>=0)
        {
            if(board[dr][dc]=='Q')
            {
                return false;
            }
            dr--;
            dc--;
        }
        dr=row;
        dc=col;
        while(dc>=0)
        {
            if(board[dr][dc]=='Q')
            {
                return false;
            }
            dc--;
        }
        dr=row;
        dc=col;
        while(dc>=0 && dr<board.length)
        {
            if(board[dr][dc]=='Q')
            {
                return false;
            }
            dc--;
            dr++;
        }
        return true;
    }
}