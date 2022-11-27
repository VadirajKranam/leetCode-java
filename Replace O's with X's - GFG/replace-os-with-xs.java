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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int[][] vis=new int[a.length][a[0].length];
        for(int j=0;j<a[0].length;j++)
        {
            if(a[0][j]=='O')
            {
                dfs(0,j,a,vis);
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i][a[0].length-1]=='O')
            {
                dfs(i,a[0].length-1,a,vis);
            }
        }
        for(int j=0;j<a[0].length;j++)
        {
            if(a[a.length-1][j]=='O')
            {
                dfs(a.length-1,j,a,vis);
            }
        }
        for(int i=0;i<a.length;i++)
        {
            if(a[i][0]=='O')
            {
                dfs(i,0,a,vis);
            }
        }
        char[][] ans=new char[a.length][a[0].length];
        for(int i=0;i<vis.length;i++)
        {
            for(int j=0;j<vis[i].length;j++)
            {
                if(vis[i][j]==0)
                {
                    ans[i][j]='X';
                }
                else
                {
                    ans[i][j]='O';
                }
            }
        }
        return ans;
    }
    static void dfs(int i,int j,char[][] a,int[][] vis)
    {
        if(i<0 || j<0 || i>=a.length || j>=a[0].length || a[i][j]=='X' || vis[i][j]==1)
        {
            return;
        }
        vis[i][j]=1;
        dfs(i-1,j,a,vis);
        dfs(i,j+1,a,vis);
        dfs(i+1,j,a,vis);
        dfs(i,j-1,a,vis);
    }
}