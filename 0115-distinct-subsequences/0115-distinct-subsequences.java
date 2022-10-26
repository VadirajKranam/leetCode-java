class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int i=0;i<=t.length();i++)
        {
            dp[0][i]=0;
        }
        for(int i=0;i<=s.length();i++)
        {
            dp[i][0]=1;
        }
        for(int i1=1;i1<dp.length;i1++)
        {
            for(int i2=1;i2<dp[i1].length;i2++)
            {
                if(s.charAt(i1-1)==t.charAt(i2-1))
                {
                    dp[i1][i2]=dp[i1-1][i2-1]+dp[i1-1][i2];
                }
                else
                {
                    dp[i1][i2]=dp[i1-1][i2];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
    public int function(int i,int j,String s,String t,int[][] dp)
    {
        if(j<0)
        {
            return 1;
        }
        if(i<0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s.charAt(i)==t.charAt(j))
        {
            return dp[i][j]=function(i-1,j-1,s,t,dp)+function(i-1,j,s,t,dp);
        }
        return dp[i][j]=function(i-1,j,s,t,dp);
    }
}