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
     public  boolean function(int i,int j,String s1,String s2,int[][] dp)
    {
        if(i<0 && j<0)
        {
            return true;
        }
        if((i<0 && j>=0))
        {
            return false;
        }
        if(j<0 && i>=0)
        {
            while(i>=0)
            {
                if(s1.charAt(i)!='*')
                {
                    return false;
                }
                i--;
            }
            return true;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j]==1?true:false;
        }
        if(s1.charAt(i)==s2.charAt(j) || s1.charAt(i)=='?')
        {
            dp[i][j]=1;
            return function(i-1,j-1,s1,s2,dp);
        }
        else if(s1.charAt(i)=='*')
        {
            boolean f1=function(i,j-1,s1,s2,dp);
            boolean f2=function(i-1,j,s1,s2,dp);
            if((f1||f2))
            {
                dp[i][j]=1;
            }
            else
            {
                dp[i][j]=0;
            }
            return (f1||f2);
        }
        dp[i][j]=0;
        return s1.charAt(i)==s2.charAt(j);
    }
}