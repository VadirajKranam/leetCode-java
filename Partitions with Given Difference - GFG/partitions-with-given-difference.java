//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int n, int d, int arr[]){
        int tot=0;
        for(int i=0;i<arr.length;i++)
        {
            tot+=arr[i]%1000000007;
        }
        if(tot<d)
        {
            return 0;
        }
        if((tot-d)%2==1)
        {
            return 0;
        }
        int sum=((tot-d)/2)%1000000007;
        int[][] dp=new int[arr.length][sum+1];
        for(int[] d1:dp)
        {
            Arrays.fill(d1,-1);
        }
        return function(0,arr,sum,dp)%1000000007;
    }
    public int function(int i,int[] arr,int sum,int[][] dp)
    {
        if(i==arr.length-1)
        {
            if(sum==0 && arr[i]==0)
            {
                return 2;
            }
            if(sum==0 || arr[i]==sum)
            {
                return 1;
            }
            return 0;
        }
        if(dp[i][sum]!=-1)
        {
            return dp[i][sum]%1000000007;
        }
        int notTake=function(i+1,arr,sum,dp)%1000000007;
        int take=0;
        if(arr[i]<=sum)
        {
            take=function(i+1,arr,sum-arr[i],dp)%1000000007;
        }
        return dp[i][sum]=(take%1000000007+notTake%1000000007)%1000000007;
    }
}