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
    static int countMin(String str)
    {
          StringBuilder t1=new StringBuilder(str);
          String t2=t1.reverse().toString();
          int[][] dp=new int[str.length()][t2.length()];
          for(int[] d:dp)
          {
              Arrays.fill(d,-1);
          }
          int count=lcs(t1.length()-1,t2.length()-1,str.toCharArray(),t2.toCharArray(),dp);
          return str.length()-count;
    }
    static int lcs(int i,int j,char[] s1,char[] s2,int[][] dp)
    {
       if(i<0 || j<0)
       {
           return 0;
       }
       if(dp[i][j]!=-1)
       {
           return dp[i][j];
       }
       if(s1[i]==s2[j])
       {
           return 1+lcs(i-1,j-1,s1,s2,dp);
       }
       return dp[i][j]=Math.max(lcs(i-1,j,s1,s2,dp),lcs(i,j-1,s1,s2,dp));
    }
}