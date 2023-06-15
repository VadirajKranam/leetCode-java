//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String S){
       String m="";
       int longest=0;
       for(int i=0;i<S.length();i++)
       {
           int start=i,end=i;
           while(start>=0 && end<S.length() && S.charAt(start)==S.charAt(end))
           {
               if(end-start+1>longest)
               {
                   longest=end-start+1;
                   m=S.substring(start,end+1);
               }
               start--;
               end++;
           }
           start=i;
           end=i+1;
           while(start>=0 && end<S.length() && S.charAt(start)==S.charAt(end))
           {
               if(end-start+1>longest)
               {
                   longest=end-start+1;
                   m=S.substring(start,end+1);
               }
               start--;
               end++;
           }
       }
       return m;
    }
}