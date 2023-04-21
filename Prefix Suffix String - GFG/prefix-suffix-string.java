//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class code1 
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[]=in.readLine().trim().split(" ");
            String s2[]=in.readLine().trim().split(" ");

            Solution ob=new Solution();
            int ans=ob.prefixSuffixString(s1,s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int prefixSuffixString(String s1[],String s2[])
    {
       int count=0;
       for(int i=0;i<s2.length;i++)
       {
           for(int j=0;j<s1.length;j++)
           {
               if(s1[j].startsWith(s2[i]))
               {
                   count++;
                   break;
               }
               else if(s1[j].endsWith(s2[i]))
               {
                   count++;
                   break;
               }
           }
       }
       return count;
    }
}
  