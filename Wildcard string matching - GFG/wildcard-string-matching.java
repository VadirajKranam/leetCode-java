//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean match(String wild, String pattern)
    {
        int[][] dp=new int[wild.length()+1][pattern.length()+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,0,wild,pattern,dp);
    }
    static boolean function(int i1,int i2,String s1,String s2,int[][] dp)
    {
        if(i1>=s1.length() && i2>=s2.length())
        {
            return true;
        }
        if(i1>=s1.length() && i2<s2.length())
        {
            return false;
        }
        if(i2>=s2.length() && i1<s1.length())
        {
            while(i1<s1.length())
            {
                if(s1.charAt(i1)!='*')
                {
                    return false;
                }
                i1++;
            }
            return true;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2]==1?true:false;
        }
        if(s1.charAt(i1)==s2.charAt(i2)||s1.charAt(i1)=='?')
        {
            dp[i1][i2]=1;
            return function(i1+1,i2+1,s1,s2,dp);
        }
        if(s1.charAt(i1)=='*')
        {
            boolean f1=function(i1,i2+1,s1,s2,dp);
            boolean f2=function(i1+1,i2,s1,s2,dp);
            if(f1|f2)
            {
                dp[i1][i2]=1;
            }
            else
            {
                dp[i1][i2]=0;
            }
            return f1|f2;
        }
        dp[i1][i2]=0;
        return false;
    }
}