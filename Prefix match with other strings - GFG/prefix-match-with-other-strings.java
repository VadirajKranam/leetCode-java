//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for(int i=0;i<n;i++)
            {
                arr[i] = sc.next();
            }
            
            int k = Integer.parseInt(sc.next());
            
            String str = sc.next();
            
            Solution obj = new Solution();
            int ans = obj.klengthpref(arr,n,k,str);
            System.out.println(ans);
            
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int klengthpref(String[] arr, int n, int k, String str)
    {
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            int i1=0;
            int i2=0;
            int k1=k;
            while(k1!=0 && i1<arr[i].length() && i2<str.length())
            {
                if(arr[i].charAt(i1)!=str.charAt(i2))
                {
                    break;
                }
                i1++;
                i2++;
                k1--;
            }
            if(k1==0)
            {
                count++;
            }
        }
        return count;
    }
}