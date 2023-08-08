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
            int k=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.solve(N, k, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int solve(int N, int k, int arr[]){
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return function(0,arr,dp,k);
    }
    public int function(int i,int[] arr,int[] dp,int k)
    {
        if(i==arr.length)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int maxAns=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        int len=0;
        for(int j=i;j<Math.min(arr.length,i+k);j++)
        {
            len++;
            max=Math.max(max,arr[j]);
            maxAns=Math.max(maxAns,len*max+function(j+1,arr,dp,k));
        }
        return dp[i]=maxAns;
    }
}