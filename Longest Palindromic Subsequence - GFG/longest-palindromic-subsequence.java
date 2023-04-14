//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s1)
    {
        StringBuilder t=new StringBuilder();
        t.append(s1);
        String s2=t.reverse().toString();
        int[][] dp=new int[s1.length()][s1.length()];
        for(int[] r:dp)
        {
            Arrays.fill(r,-1);
        }
        return function(0,0,s1,s2,dp);
    }
    public int function(int i1,int i2,String s1,String s2,int[][] dp)
    {
        if(i1>=s1.length()||i2>=s2.length())
        {
            return 0;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2))
        {
            return dp[i1][i2]=1+function(i1+1,i2+1,s1,s2,dp);
        }
        return dp[i1][i2]=0+Math.max(function(i1+1,i2,s1,s2,dp),function(i1,i2+1,s1,s2,dp));
    }
}