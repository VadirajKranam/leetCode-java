//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
         int[][] matrix=new int[n][n];
        for(int[] mat:matrix)
        {
            Arrays.fill(mat,(int)1e9);
        }
        for(int i=0;i<edges.length;i++)
        {
            matrix[edges[i][0]][edges[i][1]]=edges[i][2];
             matrix[edges[i][1]][edges[i][0]]=edges[i][2];
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(i==j)
                {
                    matrix[i][j]=0;
                }
            }
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<matrix.length;i++)
            {
                for(int j=0;j<matrix[i].length;j++)
                {
                   matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        int cnCity=n;
        int cityNo=-1;
        for(int city=0;city<n;city++)
        {
            int cnt=0;
            for(int adjCity=0;adjCity<n;adjCity++)
            {
                if(matrix[city][adjCity]<=distanceThreshold)
                {
                    cnt++;
                }
            }
            if(cnt<=cnCity)
            {
                cnCity=cnt;
                cityNo=city;
            }
        }
        return cityNo;
      }
}
