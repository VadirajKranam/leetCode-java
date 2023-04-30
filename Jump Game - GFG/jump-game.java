//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S1[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S1[i]);

            Solution ob = new Solution();
            System.out.println(ob.canReach(A,N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int canReach(int[] A, int N) {
        int[] dp=new int[A.length];
        Arrays.fill(dp,-1);
        return function(0,A,dp);
    }
    static int function(int ind,int[] A,int[] dp)
    {
        if(ind==A.length-1)
        {
            return 1;
        }
        if(dp[ind]!=-1)
        {
            return dp[ind];
        }
        if(ind>=A.length || A[ind]==0)
        {
            return 0;
        }
        for(int j=1;j<=A[ind];j++)
        {
            if(function(ind+j,A,dp)==1)
            {
                return dp[ind+j]=1;
            }
        }
        return dp[ind]=0;
    }
};