//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        int[] dp=new int[str.length()+1];
        Arrays.fill(dp,-1);
        return function(0,str,dp)-1;
    }
    static int function(int i,String s,int[] dp)
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
        for(int j=i;j<=s.length()-1;j++)
        {
            if(isPallindrome(i,j,s))
            {
                int count=1+function(j+1,s,dp);
                min=Math.min(min,count);
            }
        }
        return dp[i]=min;
    }
    static boolean isPallindrome(int i,int j,String s)
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