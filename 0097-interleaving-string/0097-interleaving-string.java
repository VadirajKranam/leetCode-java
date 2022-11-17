class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
       Boolean[][] dp=new Boolean[s1.length()+1][s2.length()+1];
        
        return function(s1,s2,s3,dp,0,0);
    }
    public boolean function(String s1,String s2,String s3,Boolean[][] dp,int i,int j)
    {
        if(i+j==s3.length())
        {
            return true;
        }
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        if(i<s1.length() && s3.charAt(i+j)==s1.charAt(i))
        {
            boolean flag=function(s1,s2,s3,dp,i+1,j);
            dp[i][j]=flag;
            if(flag)
                return true;
        }
        if(j<s2.length() && s3.charAt(i+j)==s2.charAt(j))
        {
            boolean flag=function(s1,s2,s3,dp,i,j+1);
            dp[i][j]=flag;
            if(flag)
                return true;
        }
        return dp[i][j]=false;
    }
}