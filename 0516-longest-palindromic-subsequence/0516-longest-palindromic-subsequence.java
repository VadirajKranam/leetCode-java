class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder st=new StringBuilder();
        st.append(s);
        String s2=st.reverse().toString();
        int[][] dp=new int[s.length()+1][s2.length()+1];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        for(int i=0;i<s.length();i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<s2.length();j++)
        {
            dp[0][j]=0;
        }
        for(int ind1=1;ind1<dp.length;ind1++)
        {
            for(int ind2=1;ind2<dp[ind1].length;ind2++)
            {
                if(s.charAt(ind1-1)==s2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else
                {
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return dp[s.length()][s2.length()];
    }
}