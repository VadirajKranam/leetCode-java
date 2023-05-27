//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
       int count=0;
       int low=0,high=arr.length-1;
       int ind=-1;
       while(low<=high)
       {
           int mid=low+(high-low)/2;
           if(arr[mid]==x)
           {
              ind=mid;
              break;
           }
           else if(arr[mid]<x)
           {
               low=mid+1;
           }
           else
           {
               high=mid-1;
           }
       }
       if(ind==-1)
       {
           return 0;
       }
       int left=ind-1;
       while(left>=0 && arr[left]==x)
       {
           count++;
           left--;
       }
       while(ind<arr.length && arr[ind]==x)
       {
           count++;
           ind++;
       }
       return count;
    }
}