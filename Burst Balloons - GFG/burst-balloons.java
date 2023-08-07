//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] arr) {
    // code here
     int[] bal=new int[arr.length+2];
     bal[0]=1;
     bal[arr.length+1]=1;
     for(int i=1;i<=arr.length;i++)
     {
         bal[i]=arr[i-1];
     }
     int[][] dp=new int[arr.length+1][arr.length+1];
     for(int[] d:dp)
     {
         Arrays.fill(d,-1);
     }
     return function(1,arr.length,bal,dp);
  }
  public static int function(int i,int j,int[] bal,int[][] dp)
  {
      if(i>j)
      {
          return 0;
      }
      if(dp[i][j]!=-1)
      {
          return dp[i][j];
      }
      int max=Integer.MIN_VALUE;
      for(int k=i;k<=j;k++)
      {
          int ans=bal[i-1]*bal[k]*bal[j+1]+function(i,k-1,bal,dp)+function(k+1,j,bal,dp);
          max=Math.max(max,ans);
      }
      return dp[i][j]=max;
  }
}
     