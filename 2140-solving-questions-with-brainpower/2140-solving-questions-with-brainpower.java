class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp=new long[questions.length+1];
        Arrays.fill(dp,-1l);
        return function(0,questions,dp);
    }
    public long function(int i,int[][] questions,long[] dp)
    {
        if(i>=questions.length)
        {
            return 0;
        }
        if(dp[i]!=-1l)
        {
            return dp[i];
        }
        return dp[i]=Math.max(function(i+1,questions,dp),questions[i][0]+function(i+questions[i][1]+1,questions,dp));
    }
}