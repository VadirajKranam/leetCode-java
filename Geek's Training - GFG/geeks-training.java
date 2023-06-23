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
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int maximumPoints(int points[][],int N){
       int[][] dp=new int[points.length][4];
       for(int[] d:dp)
       {
           Arrays.fill(d,-1);
       }
       return function(0,points,3,dp);
    }
    public int function(int i,int[][] points,int last,int[][] dp)
    {
        if(i==points.length-1)
        {
            int max=0;
            for(int j=0;j<3;j++)
            {
                if(last!=j)
                {
                    max=Math.max(max,points[i][j]);
                }
            }
            return dp[i][last]=max;
        }
        if(dp[i][last]!=-1)
        {
            return dp[i][last];
        }
        int max=0;
        for(int j=0;j<3;j++)
        {
            if(j!=last)
            {
                max=Math.max(max,points[i][j]+function(i+1,points,j,dp));
            }
        }
        return dp[i][last]=max;
    }
   
}

