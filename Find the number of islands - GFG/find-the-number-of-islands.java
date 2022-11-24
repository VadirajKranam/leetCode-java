//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int[][] vis=new int[grid.length][grid[0].length];
        for(int[] v:vis)
        {
            Arrays.fill(v,0);
        }
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            Queue<Integer> q=new LinkedList<>();
            for(int j=0;j<grid[i].length;j++)
            {
                if(vis[i][j]==0 && grid[i][j]=='1')
                {
                    bfs(i,j,grid,vis);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i,int j,char[][] grid,int[][] vis)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j]==1 || grid[i][j]=='0')
        {
            return;
        }
        vis[i][j]=1;
        bfs(i-1,j,grid,vis);
        bfs(i-1,j+1,grid,vis);
        bfs(i,j+1,grid,vis);
        bfs(i+1,j+1,grid,vis);
        bfs(i+1,j,grid,vis);
        bfs(i+1,j-1,grid,vis);
        bfs(i,j-1,grid,vis);
        bfs(i-1,j-1,grid,vis);
    }
}










