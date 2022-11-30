//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int[][] ans=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                ans[i][j]=grid[i][j];
            }
        }
       for(int i=0;i<ans.length;i++)
       {
           if(ans[i][0]==1)
           {
               dfs(i,0,ans);
           }
       }
       for(int j=0;j<ans[0].length;j++)
       {
           if(ans[0][j]==1)
           {
               dfs(0,j,ans);
           }
       }
       for(int i=0;i<ans.length;i++)
       {
           if(ans[i][ans[0].length-1]==1)
           {
               dfs(i,ans[0].length-1,ans);
           }
       }
       for(int j=0;j<ans[0].length;j++)
       {
           if(ans[ans.length-1][j]==1)
           {
               dfs(ans.length-1,j,ans);
           }
       }
       int count=0;
       for(int i=0;i<ans.length;i++)
       {
           for(int j=0;j<ans[i].length;j++)
           {
               if(ans[i][j]==1)
               {
                   count++;
               }
           }
       }
    
       return count;
    }
    public static void dfs(int i,int j,int[][] ans)
    {
        if(i<0 || j<0 || i>=ans.length || j>=ans[0].length || ans[i][j]==0)
        {
            return;
        }
        ans[i][j]=0;
        dfs(i-1,j,ans);
        dfs(i,j+1,ans);
        dfs(i+1,j,ans);
        dfs(i,j-1,ans);
    }
}