class Solution {
    public boolean isMatch(String s, String p) {
        int[][] dp=new int[p.length()][s.length()];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
       boolean f= function(p.length()-1,s.length()-1,p,s,dp);  
        return f;
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