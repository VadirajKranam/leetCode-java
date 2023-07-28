//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String s1)
    {
        StringBuilder t=new StringBuilder(s1);
        t=t.reverse();
        String s2=new String(t);
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int[] d:dp)
        {
            Arrays.fill(d,-1);
        }
        return s1.length()-function(0,0,s1,s2,dp);
    }
    static int function(int i1,int i2,String s1,String s2,int[][] dp)
    {
        if(i1>=s1.length() || i2>=s2.length())
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