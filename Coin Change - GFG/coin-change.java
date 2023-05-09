//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends


// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
       long[][] dp=new long[coins.length][sum+1];
        for(long[] d:dp)
        {
            Arrays.fill(d,-1l);
        }
        return function(0,coins,sum,dp);
    }
    public long function(int i,int[] coins,int sum,long[][] dp)
    {
        if(sum==0)
        {
            return 1l;
        }
        if(i==coins.length || sum<0)
        {
            return 0;
        }
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum];
        }
        return dp[i][sum]=function(i,coins,sum-coins[i],dp)+function(i+1,coins,sum,dp);
    }
}




