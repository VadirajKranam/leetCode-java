//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp=new int[S1.length()+1][S2.length()+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,0,S1,S2,dp);
    }
    int function(int i1,int i2,String s1,String s2,int[][] dp)
    {
        if(i1>=s1.length() || i2>=s2.length())
        {
            return 0;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2];
        }
        if(s1.charAt(i1)!=s2.charAt(i2))
        {
            return dp[i1][i2]=Math.max(function(i1+1,i2,s1,s2,dp),function(i1,i2+1,s1,s2,dp));
        }
        int count=0;
        int i=i1,j=i2;
        while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j))
        {
            count++;
            i++;
            j++;
        }
        return dp[i1][i2]=Math.max(count,Math.max(function(i1+1,i2,s1,s2,dp),function(i1,i2+1,s1,s2,dp)));
    }
    
    
    
    
    
}