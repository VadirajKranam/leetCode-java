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
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int NthRoot(int n, int m)
    {
        double lo=1,hi=m;
        double esp=1e-7;
        while((hi-lo)>esp)
        {
            double mid=(lo+hi)/2.0;
            if(multiply(mid,n)<m)
            {
                lo=mid;
            }
            else
            {
                hi=mid;
            }
        }
        double ans=1;
        while(n!=0)
        {
            ans*=Math.ceil(lo);
            n--;
        }
        if(ans!=m)
        {
            return -1;
        }
        return (int)Math.ceil(lo);
    }
    public double multiply(double mid,int n)
    {
        double ans=1;
        while(n!=0)
        {
            ans*=mid;
            n--;
        }
        return ans;
    }
}