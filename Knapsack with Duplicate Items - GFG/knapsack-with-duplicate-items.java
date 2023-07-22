//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp=new int[val.length][W+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,val,wt,W,dp);
    }
    static int function(int i,int[] v,int[] wt,int w,int[][] dp)
    {
        if(i==v.length-1)
        {
            return (w/wt[i])*v[i];
        }
        if(dp[i][w]!=-1)
        {
            return dp[i][w];
        }
        int notPick=function(i+1,v,wt,w,dp);
        int pick=Integer.MIN_VALUE;
        if(wt[i]<=w)
        {
            pick=v[i]+function(i,v,wt,w-wt[i],dp);
        }
       return  dp[i][w]=Math.max(notPick,pick);
    }
}