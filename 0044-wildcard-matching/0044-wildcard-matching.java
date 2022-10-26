class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        for(boolean[] r:dp)
        {
            Arrays.fill(r,false);
        }
       dp[0][0]=true;
        for(int i=1;i<dp.length;i++)
        {
            dp[i][0]=false;
        }
        for(int j=1;j<dp[0].length;j++)
        {
            dp[0][j]=false;
        }
        for(int i=1;i<dp.length;i++)
        {
           dp[i][0]=isAllStars(p,i);
        }
        for(int i1=1;i1<=p.length();i1++)
        {
            for(int i2=1;i2<=s.length();i2++)
            {
               if(p.charAt(i1-1)==s.charAt(i2-1) || p.charAt(i1-1)=='?')
              {
                dp[i1][i2]=dp[i1-1][i2-1];
              } 
                 else if(p.charAt(i1-1)=='*')
              {
                 boolean f1=dp[i1][i2-1];
                 boolean f2=dp[i1-1][i2];
                 dp[i1][i2]=f1||f2;
              }
                else
                {
                    dp[i1][i2]=false;
                }
                
            }
        }
        return dp[p.length()][s.length()];
    }
    public boolean isAllStars(String p,int i)
    {
        for(int j=1;j<=i;j++)
        {
            if(p.charAt(j-1)!='*')
            {
                return false;
            }
        }
        return true;
    }
}