class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        return function(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
    public int function(int ind1,int ind2,String t1,String t2,int[][] dp)
    {
        if(ind1<0 || ind2<0)
        {
            return 0;
        }
        if(t1.charAt(ind1)==t2.charAt(ind2))
        {
            return 1+function(ind1-1,ind2-1,t1,t2,dp);
        }
        if(dp[ind1][ind2]!=-1)
        {
            return dp[ind1][ind2];
        }
        return dp[ind1][ind2]=Math.max(function(ind1-1,ind2,t1,t2,dp),function(ind1,ind2-1,t1,t2,dp));
    }
}