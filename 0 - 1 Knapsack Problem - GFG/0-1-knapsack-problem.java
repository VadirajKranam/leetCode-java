//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading number of elements and weight
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            
            //inserting the values
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            
            //inserting the weigths
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            //calling method knapSack() of class Knapsack
            System.out.println(new Solution().knapSack(w, wt, val, n));
        }
    }
}




// } Driver Code Ends


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         int[][] dp=new int[wt.length][W+1];
         for(int[] d:dp)
         {
             Arrays.fill(d,-1);
         }
         return function(0,wt,val,W,dp);
    } 
    static int function(int i,int[] wt,int[] val,int w,int[][] dp)
    {
        if(i==wt.length-1)
        {
            if(wt[i]<=w)
            {
                return val[i];
            }
            return 0;
        }
        if(dp[i][w]!=-1)
        {
            return dp[i][w];
        }
        int notTake=function(i+1,wt,val,w,dp);
        int take=Integer.MIN_VALUE;
        if(wt[i]<=w)
        {
            take=val[i]+function(i+1,wt,val,w-wt[i],dp);
        }
        return dp[i][w]=Math.max(notTake,take);
    }
}


