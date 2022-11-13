class Solution {
    public int longestStrChain(String[] words) {
        int[] dp=new int[words.length];
        Arrays.fill(dp,1);
        Arrays.sort(words,Comparator.comparing(s->s.length()));
        int maxi=-1;
        for(int i=0;i<words.length;i++)
        {
            for(int pre=0;pre<i;pre++)
            {
                if(compare(words[i],words[pre])==1 && 1+dp[pre]>dp[i])
                {
                    dp[i]=1+dp[pre];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
    public int compare(String w1,String w2)
    {
        int i=0,j=0;
        if(w1.length()-w2.length()!=1)
        {
            return 0;
        }
    
        while(i<w1.length())
        {
            if(j<w2.length() && w1.charAt(i)==w2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        if(i==w1.length() && j==w2.length())
        {
            return 1;
        }
        return 0;
    }
}