class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,0);
        }
        for(int i=0;i<=s1.length();i++)
        {
            dp[i][0]=i;
        }
        for(int i=0;i<=s2.length();i++)
        {
            dp[0][i]=i;
        }
        for(int i1=1;i1<=s1.length();i1++)
        {
            for(int i2=1;i2<=s2.length();i2++)
            {
                if(s1.charAt(i1-1)==s2.charAt(i2-1))
                {
                    dp[i1][i2]=dp[i1-1][i2-1];
                }
                else
                {
                    int k1=1+dp[i1][i2-1];
                    int k2=1+dp[i1-1][i2];
                    int k3=1+dp[i1-1][i2-1];
                    dp[i1][i2]=Math.min(k1,Math.min(k2,k3));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    public int function(int i,int j,String s1,String s2,int[][] dp)
    {
        if(j<0)
        {
            return i+1;
        }
        if(i<0)
        {
            return j+1;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=function(i-1,j-1,s1,s2,dp);
        }
        int c1=1+function(i,j-1,s1,s2,dp);
        int c2=1+function(i-1,j,s1,s2,dp);
        int c3=1+function(i-1,j-1,s1,s2,dp);
        return dp[i][j]=Math.min(c1,Math.min(c2,c3));
    }
}