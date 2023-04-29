//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            
            long n=Long.parseLong(in.readLine());
            Solution ob=new Solution();
            out.println(ob.findNumber(n));
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long findNumber(long N)
    {
        long ans=0;
        while(N!=0)
        {
            ans*=10;
            if(N%5==0)
            {
                ans+=9;
                N/=5;
                N--;
            }
            else if(N%5==1)
            {
                ans+=1;
                N/=5;
            }
            else if(N%5==2)
            {
                ans+=3;
                N/=5;
            }
            else if(N%5==3)
            {
                ans+=5;
                N/=5;
            }
            else
            {
                ans+=7;
                N/=5;
            }
        }
       long rev=0;
       while(ans!=0)
       {
           rev=rev*10+ans%10;
           ans/=10;
       }
       return rev;
    }
}