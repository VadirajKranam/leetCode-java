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
            int N=sc.nextInt();
            int K=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.minimizeCost(arr,N,K);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimizeCost(int arr[],int N,int K){
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return function(0,arr,K,dp);
    }
    public int function(int i,int[] arr,int k,int[] dp)
    {
        if(i==arr.length-1)
        {
            return 0;
        }
        if(i>=arr.length)
        {
            return 99999999;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int ans=99999999;
        for(int j=1;j<=k;j++)
        {
            if(i+j>=arr.length)
            {
                break;
            }
           ans=Math.min(ans,Math.abs(arr[i]-arr[i+j])+function(i+j,arr,k,dp));
        }
        return dp[i]=ans;
    }
}
