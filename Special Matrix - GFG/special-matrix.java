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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int k = Integer.parseInt(s[2]);
            int[][] blocked_cells = new int[k][2];
            for(int i = 0; i < k; i++){
                String[] s1 = br.readLine().trim().split(" ");
                for(int j = 0; j < 2; j++){
                    blocked_cells[i][j] = Integer.parseInt(s1[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.FindWays(n, m, blocked_cells);
            System.out.println(ans);

        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        int[][] mat=new int[n][m];
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(mat[i],1);
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<blocked_cells.length;i++)
        {
            int row=blocked_cells[i][0]-1;
            int col=blocked_cells[i][1]-1;
            mat[row][col]=0;
        }
        return function(0,0,mat,dp)%1000000007;
    }
    public int function(int i,int j,int[][] mat,int[][] dp)
    {
        if(i==mat.length-1 && j==mat[i].length-1 && mat[i][j]!=0)
        {
            return 1;
        }
        if(i>=mat.length || j>=mat[i].length || mat[i][j]==0)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
       return dp[i][j]=(function(i+1,j,mat,dp)+function(i,j+1,mat,dp));
    }
}