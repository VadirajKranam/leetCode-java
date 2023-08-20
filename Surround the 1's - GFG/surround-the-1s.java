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
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int  Count(int[][] matrix)
    {
       int count=0;
       for(int i=0;i<matrix.length;i++)
       {
           for(int j=0;j<matrix[i].length;j++)
           {
               if(matrix[i][j]==1)
               {
                   int z=0;
                   if(i-1>=0 && matrix[i-1][j]==0)
                   {
                       z++;
                   }
                   if(j-1>=0 && matrix[i][j-1]==0)
                   {
                       z++;
                   }
                   if(i+1<matrix.length && matrix[i+1][j]==0)
                   {
                       z++;
                   }
                   if(j+1<matrix[0].length && matrix[i][j+1]==0)
                   {
                       z++;
                   }
                   if(i+1<matrix.length && j-1>=0 && matrix[i+1][j-1]==0)
                   {
                       z++;
                   }
                   if(j-1>=0 && i-1>=0 && matrix[i-1][j-1]==0)
                   {
                       z++;
                   }
                   if(i+1<matrix.length && j+1<matrix[i].length && matrix[i+1][j+1]==0)
                   {
                       z++;
                   }
                   if(j+1<matrix[0].length && i-1>=0 && matrix[i-1][j+1]==0)
                   {
                       z++;
                   }
                   if(z>0 && z%2==0)
                   {
                       count++;
                   }
               }
           }
       }
       return count;
    }
}