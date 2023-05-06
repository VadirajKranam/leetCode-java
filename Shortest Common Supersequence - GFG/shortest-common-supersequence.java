//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		
		sc.nextLine();
		while(t-->0)
		{
		   //taking String X and Y
		   String S[]=sc.nextLine().split(" ");
		   String X=S[0];
		   String Y=S[1];
		   
		   //calling function shortestCommonSupersequence()
		   System.out.println(new Solution().shortestCommonSupersequence(X, Y, X.length(), Y.length()));
		}
	}




       
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        int[][] dp=new int[X.length()][Y.length()];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        int lcs=function(0,0,X,Y,dp);
        int c1=X.length()-lcs;
        int c2=Y.length()-lcs;
        return c1+c2+lcs;
    }
    public static int function(int i1,int i2,String s1,String s2,int[][] dp)
    {
        if(i1>=s1.length()||i2>=s2.length())
        {
            return 0;
        }
        if(dp[i1][i2]!=-1)
        {
            return dp[i1][i2];
        }
        if(s1.charAt(i1)==s2.charAt(i2))
        {
            return dp[i1][i2]=1+function(i1+1,i2+1,s1,s2,dp);
        }
        return dp[i1][i2]=Math.max(function(i1+1,i2,s1,s2,dp),function(i1,i2+1,s1,s2,dp));
    }
}




