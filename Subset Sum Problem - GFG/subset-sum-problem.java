//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        int[][] dp=new int[arr.length][sum+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,arr,dp,sum);
    }
    static Boolean function(int i,int[] arr,int[][] dp,int sum)
    {
        if(sum==0)
        {
            return true;
        }
        if(i>=arr.length || sum<0)
        {
            return false;
        }
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum]==1;
        }
        Boolean notTake=function(i+1,arr,dp,sum);
        Boolean take=false;
        if(arr[i]<=sum)
        {
            take=function(i+1,arr,dp,sum-arr[i]);
        }
        if(notTake||take)
        {
            dp[i][sum]=1;
        }
        else
        {
            dp[i][sum]=0;
        }
        return take||notTake;
    }
}