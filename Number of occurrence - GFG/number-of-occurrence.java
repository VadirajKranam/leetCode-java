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
      int ind=-1;
      int i=0,j=arr.length-1;
      while(i<=j)
      {
          int m=i+(j-i)/2;
          if(arr[m]==x)
          {
              ind=m;
              break;
          }
          else if(arr[m]>x)
          {
              j--;
          }
          else
          {
              i++;
          }
      }
      if(ind==-1)
      {
          return 0;
      }
      int count=0;
      int b=ind;
      while(b>=0 && arr[b]==x)
      {
          count++;
          b--;
      }
      b=ind+1;
      while(b<arr.length && arr[b]==x)
      {
          count++;
          b++;
      }
      return count;
    }
}