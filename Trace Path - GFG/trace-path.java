//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String srgs[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s1[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution{
    static int isPossible(int n, int m, String s){
       int tl=0,tr=0,tu=0,td=0;
       int flr=0,fud=0;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)=='L')
           {
               flr++;
           }
           else if(s.charAt(i)=='R')
           {
               flr--;
           }
           else if(s.charAt(i)=='U')
           {
               fud++;
           }
           else
           {
               fud--;
           }
           if(flr>=0)
           {
               tl=Math.max(tl,flr);
           }
           else
           {
               tr=Math.min(tr,flr);
           }
           if(fud>=0)
           {
               tu=Math.max(tu,fud);
           }
           else
           {
               td=Math.min(td,fud);
           }
       }
       if(tl-tr<m && tu-td<n)
       {
           return 1;
       }
       return 0;
    }
}