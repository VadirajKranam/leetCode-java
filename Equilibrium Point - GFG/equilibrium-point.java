//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            
            //taking input n
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");
            
            //adding elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            //calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
       long[] sum1=new long[arr.length];
       long sum=0;
       for(int i=0;i<arr.length;i++)
       {
           sum+=arr[i];
           sum1[i]=sum;
       }
       long[] sum2=new long[arr.length];
       sum=0;
       for(int i=arr.length-1;i>=0;i--)
       {
           sum+=arr[i];
           sum2[arr.length-i-1]=sum;
       }
       for(int i=0;i<n;i++)
       {
           if(sum1[i]==sum2[sum2.length-i-1])
           {
               return i+1;
           }
       }
       return -1;
    }
}
