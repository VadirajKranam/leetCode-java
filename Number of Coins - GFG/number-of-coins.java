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
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int M, int V) 
	{ 
	    int[][] dp=new int[coins.length][V+1];
	    for(int[] d:dp)
	    {
	        Arrays.fill(d,-1);
	    }
	    int ans=function(0,coins,V,dp);
	    return ans==99999999?-1:ans;
	} 
	public int function(int i,int[] coins,int sum,int[][] dp)
	{
	    if(i==coins.length-1)
	    {
	        return sum%coins[i]==0?sum/coins[i]:99999999;
	    }
	    if(dp[i][sum]!=-1)
	    {
	        return dp[i][sum];
	    }
	    int notPick=function(i+1,coins,sum,dp);
	    int pick=99999999;
	    if(coins[i]<=sum)
	    {
	        pick=1+function(i,coins,sum-coins[i],dp);
	    }
	    return dp[i][sum]=Math.min(pick,notPick);
	}
}