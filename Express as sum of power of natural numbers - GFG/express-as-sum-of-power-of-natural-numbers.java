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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int n = Integer.parseInt(input[0]); 
            int x = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numOfWays(n, x));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static final int mod=1000000007;
    static int numOfWays(int n, int x)
    {
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            int cur=(int)Math.pow(i,x);
            if(cur<=n)
            {
                al.add(cur);
            }
            else
            {
                break;
            }
        }
        int[][] dp=new int[n+1][n+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(al,0,n,al.size(),dp);
    }
    static int function(ArrayList<Integer> al,int i,int n,int size,int[][] dp)
    {
        if(n<0)
        {
            return 0;
        }
        if(i==size)
        {
            if(n==0)
            {
                return 1;
            }
            return 0;
        }
        if(dp[i][n]!=-1)
        {
            return dp[i][n]%mod;
        }
        return dp[i][n]=(function(al,i+1,n,size,dp)%mod + function(al,i+1,n-al.get(i),size,dp)%mod)%mod;
    }
}