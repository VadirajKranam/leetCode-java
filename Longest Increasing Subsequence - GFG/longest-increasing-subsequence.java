//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    int len=0;
    static int longestSubsequence(int size, int a[])
    {
        int[][] dp=new int[a.length][a.length];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return function(0,-1,a,dp);
    }
    static int function(int ind,int pi,int[] a,int[][] dp)
    {
        if(ind==a.length){
            return 0;
        }
        if(dp[ind][pi+1]!=-1)
        {
            return dp[ind][pi+1];
        }
        int len=0+function(ind+1,pi,a,dp);
        if(pi<0 || a[ind]>a[pi])
        {
            len=Math.max(len,1+function(ind+1,ind,a,dp));
        }
        return dp[ind][pi+1]=len;
    }
} 