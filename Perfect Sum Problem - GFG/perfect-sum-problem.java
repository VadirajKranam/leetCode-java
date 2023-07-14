//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp=new int[arr.length][sum+1];
	    for(int[] d:dp)
	    {
	        Arrays.fill(d,-1);
	    }
	    Arrays.sort(arr);
	    return function(0,arr,dp,sum);
	} 
	public int function(int i,int[] arr,int[][] dp,int sum)
	{
	    if(sum==0)
	    {
	        return (int) 1%1000000007;
	    }
	    if(i==arr.length-1)
	    {
	        if(sum==arr[i])
	        {
	            return (int) 1%1000000007;
	        }
	        return 0;
	    }
	    if(dp[i][sum]!=-1)
	    {
	        return (int)dp[i][sum]%1000000007;
	    }
	    int notTake=(int)function(i+1,arr,dp,sum)%1000000007;
	    int take=0;
	    if(arr[i]<=sum)
	    {
	        take=(int)function(i+1,arr,dp,sum-arr[i])%1000000007;
	    }
	    return dp[i][sum]=(int)(take+notTake)%1000000007;
	}
}