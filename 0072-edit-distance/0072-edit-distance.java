class Solution {
    public int minDistance(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        return function(s1.length()-1,s2.length()-1,s1,s2,dp);
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