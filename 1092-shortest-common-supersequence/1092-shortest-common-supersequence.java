class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++)
        {
            dp[i][0]=0;
        }
        for(int j=0;j<=s2.length();j++)
        {
            dp[0][j]=0;
        }
        for(int i1=1;i1<dp.length;i1++)
        {
            for(int i2=1;i2<dp[i1].length;i2++)
            {
                if(s1.charAt(i1-1)==s2.charAt(i2-1))
                {
                    dp[i1][i2]=1+dp[i1-1][i2-1];
                }
                else
                {
                    dp[i1][i2]=Math.max(dp[i1-1][i2],dp[i1][i2-1]);
                }
            }
        }
        int i=s1.length(),j=s2.length();
        StringBuilder ans=new StringBuilder();
        while(i>0 && j>0)
        {
            if(s1.charAt(i-1)==s2.charAt(j-1))
            {
                ans.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            {
                ans.append(s1.charAt(i-1));
                i-=1;
            }
            else
            {
                ans.append(s2.charAt(j-1));
                j-=1;
            }
        }
        
        while(i>0)
        {
           ans.append(s1.charAt(i-1));
                i-=1; 
        }
         while(j>0)
        {
           ans.append(s2.charAt(j-1));
                j-=1; 
        }
        return ans.reverse().toString();
    }
}