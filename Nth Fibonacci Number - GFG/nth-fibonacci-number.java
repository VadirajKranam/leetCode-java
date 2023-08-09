//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthFibonacci(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution {
    static int nthFibonacci(int n){
      int[] dp=new int[n+1];
      Arrays.fill(dp,-1);
      return function(n,dp);
    }
    static int function(int n,int[] dp)
    {
        if(n<=1)
        {
            return n;
        }
        if(dp[n]!=-1)
        {
            return dp[n]%1000000007;
        }
        return dp[n]=(function(n-1,dp)%1000000007+function(n-2,dp)%1000000007)%1000000007;
    }
}