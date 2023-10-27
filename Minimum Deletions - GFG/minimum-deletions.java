//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String S) {
        StringBuilder t=new StringBuilder();
        for(int i=S.length()-1;i>=0;i--)
        {
            t.append(S.charAt(i));
        }
        String s2=new String(t.toString());
        int[][] dp=new int[s2.length()+1][s2.length()+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return S.length()-function(0,0,S,s2,dp);
    }
    static int function(int i,int j,String s1,String s2,int[][] dp)
    {
        if(i>=s1.length() || j>=s2.length())
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+function(i+1,j+1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(function(i+1,j,s1,s2,dp),function(i,j+1,s1,s2,dp));
    }
}