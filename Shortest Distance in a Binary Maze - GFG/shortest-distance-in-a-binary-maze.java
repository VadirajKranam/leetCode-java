//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class trio{
    int a,b,c;
    trio(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {
       Queue<trio> q=new LinkedList<>();
       int[][] dist=new int[grid.length][grid[0].length];
       for(int i=0;i<dist.length;i++)
       {
           Arrays.fill(dist[i],Integer.MAX_VALUE);
       }
       int[] dr={-1,0,1,0};
       int[] dc={0,1,0,-1};
       dist[source[0]][source[1]]=0;
       q.offer(new trio(0,source[0],source[1]));
       while(!q.isEmpty())
       {
           int dis=q.peek().a;
           int r=q.peek().b;
           int c=q.peek().c;
           q.poll();
           for(int i=0;i<dr.length;i++)
           {
              int newr=r+dr[i];
              int newc=c+dc[i];
              if(newr>=0 && newr<grid.length && newc>=0 && newc<grid[0].length && grid[newr][newc]==1 && dis+1<dist[newr][newc])
              {
                  dist[newr][newc]=1+dis;
                  if(newr==destination[0] && newc==destination[1])
                  {
                      return 1+dis;
                  }
                  q.offer(new trio(1+dis,newr,newc));
              }
           }
       }
       if(dist[destination[0]][destination[1]]==Integer.MAX_VALUE)
       {
           return -1;
       }
       return dist[destination[0]][destination[1]];
    }
}
