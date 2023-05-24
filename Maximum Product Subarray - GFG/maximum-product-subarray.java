//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long maxLeft=Long.MIN_VALUE;
        long prod=1l;
        boolean zero=false;
        for(int i=0;i<arr.length;i++)
        {
            prod=prod*arr[i];
            if(arr[i]==0)
            {
                prod=1;
                zero=true;
                continue;
            }
            maxLeft=Math.max(maxLeft,prod);
        }
        long maxRight=Long.MIN_VALUE;
        prod=1l;
        for(int i=arr.length-1;i>=0;i--)
        {
            prod*=arr[i];
             if(arr[i]==0)
            {
                prod=1;
                continue;
            }
            maxRight=Math.max(maxRight,prod);
        }
        if(zero)
        {
            return Math.max(Math.max(maxLeft,maxRight),0);
        }
        return Math.max(maxLeft,maxRight);
    }
}