//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
       int sum=0;
       for(int i=0;i<arr.length;i++)
       {
           sum+=arr[i];
       }
       if(sum%2==1)
       {
           return 0;
       }
       sum/=2;
       int[][] dp=new int[arr.length][sum+1];
       for(int[] d:dp)
       {
           Arrays.fill(d,-1);
       }
       return function(0,arr,dp,sum);
    }
    static int function(int i,int[] arr,int[][] dp,int sum)
    {
        if(sum==0)
        {
            return 1;
        }
        if(i>=arr.length || sum<0)
        {
            return 0;
        }
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum];
        }
        int notTake=function(i+1,arr,dp,sum);
        int take=0;
        if(arr[i]<=sum)
        {
            take=function(i+1,arr,dp,sum-arr[i]);
        }
        if(take==1||notTake==1)
        {
            dp[i][sum]=1;
        }
        else
        {
            dp[i][sum]=0;
        }
        return dp[i][sum];
    }
}