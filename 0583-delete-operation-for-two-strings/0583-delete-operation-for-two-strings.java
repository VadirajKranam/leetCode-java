class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++)
        {
            dp[0][j]=0;
        }
        for(int ind1=1;ind1<dp.length;ind1++)
        {
            for(int ind2=1;ind2<dp[ind1].length;ind2++)
            {
                if(word1.charAt(ind1-1)==word2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else
                {
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);                }
            }
        }
        int deletions=word1.length()-dp[word1.length()][word2.length()];
        int insertions=word2.length()-dp[word1.length()][word2.length()];
        return deletions+insertions;
    }
}