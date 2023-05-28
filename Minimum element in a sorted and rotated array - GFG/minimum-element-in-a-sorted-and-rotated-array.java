//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0)
        {
            int n = sc.nextInt();
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        int l=0,r=arr.length-1,min=Integer.MAX_VALUE;
        while(l<=r)
        {
            if(arr[l]<=arr[r])
            {
                min=Math.min(min,arr[l]);
                break;
            }
            int m=l+(r-l)/2;
            if(arr[l]<=arr[m])
            {
                min=Math.min(min,arr[l]);
                l=m+1;
            }
            else
            {
                min=Math.min(min,arr[m]);
                r=m-1;
            }
        }
        return min;
    }
}
