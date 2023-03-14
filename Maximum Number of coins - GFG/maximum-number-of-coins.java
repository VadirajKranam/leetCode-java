//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int N = Integer.parseInt(br.readLine());
			ArrayList<Integer> arr = new ArrayList<>(N);
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				arr.add(Integer.parseInt(str[i]));
			}
			Solution obj = new Solution();
			System.out.println(obj.maxCoins(N, arr));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int maxCoins(int N, ArrayList<Integer> arr) {
		int[] balls=new int[arr.size()+2];
		balls[0]=1;
		balls[arr.size()+1]=1;
		for(int i=1;i<=arr.size();i++)
		{
		    balls[i]=arr.get(i-1);
		}
		int[][] dp=new int[balls.length+1][balls.length+1];
		for(int[] d:dp){
		Arrays.fill(d,-1);
		}
		return function(1,arr.size(),balls,dp);
	}
	int function(int i,int j,int[] balls,int[][] dp)
	{
	    if(i>j)
	    {
	        return 0;
	    }
	    if(dp[i][j]!=-1)
	    {
	        return dp[i][j];
	    }
	    int max=Integer.MIN_VALUE;
	    for(int k=i;k<=j;k++)
	    {
	        int res=balls[i-1]*balls[k]*balls[j+1]+function(i,k-1,balls,dp)+function(k+1,j,balls,dp);
	        max=Math.max(max,res);
	    }
	    return dp[i][j]=max;
	}
}