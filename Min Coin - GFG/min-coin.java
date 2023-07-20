//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinCoin(int[] nums, int amount)
    {
        int[][] dp=new int[nums.length][amount+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        int ans=function(0,nums,amount,dp);
        if(ans>=99999999)
        {
            return -1;
        }
        return ans;
    }
    public int function(int i,int[] nums,int amount,int[][] dp)
    {
        if(i==nums.length)
        {
            if(amount==0)
            {
                return 0;
            }
            return 99999999;
        }
        if(dp[i][amount]!=-1)
        {
            return dp[i][amount];
        }
        int notPick=function(i+1,nums,amount,dp);
        int pick=99999999;
        if(nums[i]<=amount)
        {
            pick=1+function(i,nums,amount-nums[i],dp);
        }
        return dp[i][amount]=Math.min(pick,notPick);
    }
}