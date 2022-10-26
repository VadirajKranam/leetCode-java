class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp=new int[s.length()+1][t.length()+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        return function(s.length()-1,t.length()-1,s,t,dp);
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