//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}
// } Driver Code Ends


class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        int s=0,e=M-1;
        while(s<N && e>=0)
        {
            if(mat[s][e]==X)
            {
                return 1;
            }
            else if(mat[s][e]<X)
            {
                s++;
            }
            else
            {
                e--;
            }
        }
        return 0;
    }
}