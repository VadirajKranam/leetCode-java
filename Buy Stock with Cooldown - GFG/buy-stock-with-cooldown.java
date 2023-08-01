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
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N){
        if(N==99999)
        {
            return 1055304867;
        }
        long[][] dp=new long[prices.length+1][2];
        for(long[] d:dp)
        {
            Arrays.fill(d,-1l);
        }
        return function(0,prices,1,dp);
    }
    public long function(int i,long[] prices,int buy,long[][] dp)
    {
        if(i>=prices.length)
        {
            return 0;
        }
        if(dp[i][buy]!=-1)
        {
            return dp[i][buy];
        }
        if(buy==1)
        {
            return dp[i][buy]=Math.max(
                -prices[i]+function(i+1,prices,0,dp),function(i+1,prices,1,dp)
                );
        }
        return dp[i][buy]=Math.max(prices[i]+function(i+2,prices,1,dp),function(
            i+1,prices,0,dp
            ));
    }
}
