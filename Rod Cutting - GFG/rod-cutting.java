//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
       int[][] dp=new int[price.length+1][n+1];
       for(int[] d:dp)
       {
           Arrays.fill(d,-1);
       }
       return function(price.length-1,price,n,dp);
    }
    public int function(int i,int[] price,int n,int[][] dp)
    {
        if(i==0)
        {
            return n*price[i];
        }
        if(dp[i][n]!=-1)
        {
            return dp[i][n];
        }
        int notTake=0+function(i-1,price,n,dp);
        int take=Integer.MIN_VALUE;
        if(i+1<=n)
        {
            take=price[i]+function(i,price,n-i-1,dp);
        }
        return dp[i][n]=Math.max(take,notTake);
    }
}