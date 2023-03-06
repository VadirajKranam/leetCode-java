//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
    static long merge(long[] arr,int l,int m,int r)
    {
        int n1=m-l+1;
        int n2=r-m;
        int k=l;
        long count=0;
        long[] left=new long[n1];
        long[] right=new long[n2];
        for(int i=0;i<n1;i++)
        {
            left[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++)
        {
            right[i]=arr[m+i+1];
        }
        int i=0,j=0;
        while(i<n1 && j<n2)
        {
            if(left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
                k++;
                
            }
            else
            {
                arr[k]=right[j];
                j++;
                k++;
                count+=(m+1)-(l+i);
            }
        }
        while(i<n1)
        {
            arr[k]=left[i];
            k++;
            i++;
        }
        while(j<n2)
        {
            arr[k]=right[j];
            k++;
            j++;
        }
        return count;
    }
    static long sort(long[] arr,int l,int r)
    {
        long count=0;
        if(l<r)
        {
            int m=l+(r-l)/2;
            count+=sort(arr,l,m);
            count+=sort(arr,m+1,r);
            count+=merge(arr,l,m,r);
        }
        return count;
    }
    static long inversionCount(long arr[], long N)
    {
        long count=0;
        count=sort(arr,0,arr.length-1);
        return count;
    }
}