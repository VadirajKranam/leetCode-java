class Solution {
    public int minCut(String s) {
        int[] dp=new int[s.length()];
            Arrays.fill(dp,-1);
      return function(0,s,dp)-1;  
    }
    public int function(int i,String s,int[] dp)
    {
        if(i==s.length())
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int min=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++)
        {
           
            if(isPallindrome(i,j,s))
            {
               int cost= 1+function(j+1,s,dp);
                min=Math.min(cost,min);
            }
        }
        return dp[i]=min;
    }
    public boolean isPallindrome(int i,int j,String s)
    {
       while(i<j)
       {
           if(s.charAt(i)!=s.charAt(j))
           {
               return false;
           }
           i++;
           j--;
       }
        return true;
    }
}