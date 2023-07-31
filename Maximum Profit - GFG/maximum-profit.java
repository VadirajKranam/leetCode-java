//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxProfit(int K, int N, int A[]) {
        int[][][] dp=new int[A.length+1][2][K+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[i].length;j++)
            {
                Arrays.fill(dp[i][j],-1);
            }
        }
        return function(0,A,1,K,dp);
    }
    static int function(int i,int[] price,int buy,int k,int[][][] dp)
    {
        if(k==0 || i==price.length)
        {
            return 0;
        }
        if(dp[i][buy][k]!=-1)
        {
            return dp[i][buy][k];
        }
        if(buy==1)
        {
            return dp[i][buy][k]=Math.max(
                -price[i]+function(i+1,price,0,k,dp),function(i+1,price,1,k,dp)
                );
        }
        return dp[i][buy][k]=Math.max(
            price[i]+function(i+1,price,1,k-1,dp),function(i+1,price,0,k,dp)
            );
    }
}