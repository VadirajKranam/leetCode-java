//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            int X = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.closest3Sum(Arr, N, X));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest3Sum(int A[], int N, int X)
    {
       Arrays.sort(A);
       int mindiff=Integer.MAX_VALUE;
       int ans=0;
       for(int i=0;i<A.length;i++)
       {
           int j=i+1;
           int k=A.length-1;
           
           while(j<k)
           {
               int sum=A[i]+A[j]+A[k];
               if(sum==X)
               {
                   return X;
               }
               else if(sum<X)
               {
                   int diff=X-sum;
                   if(diff<mindiff)
                   {
                       mindiff=diff;
                       ans=sum;
                   }
                   j++;
               }
               else
               {
                int diff=sum-X;
                   if(diff<mindiff)
                   {
                       mindiff=diff;
                       ans=sum;
                   }
                   k--;   
               }
           }
       }
       return ans;
    }
}