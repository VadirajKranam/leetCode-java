class Solution {
    public int minInsertions(String str1) {
        StringBuilder st=new StringBuilder();
        st.append(str1);
        String str2=st.reverse().toString();
        int[][] dp=new int[str1.length()+1][str2.length()+1];
        for(int ind1=1;ind1<=str1.length();ind1++)
        {
            for(int ind2=1;ind2<=str2.length();ind2++)
            {
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                {
                    dp[ind1][ind2]=1+dp[ind1-1][ind2-1];
                }
                else
                {
                    dp[ind1][ind2]=Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
                }
            }
        }
        return str1.length()-dp[str1.length()][str2.length()];
    }
}