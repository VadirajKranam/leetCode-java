//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        Arrays.sort(arr);
        int[] ans=new int[2];
        int[] count=new int[n+1];
        for(int i=0;i<arr.length;i++)
        {
            count[arr[i]]++;
        }
        for(int i=1;i<count.length;i++)
        {
            if(count[i]==0)
            {
                ans[1]=i;
            }
            else if(count[i]==2)
            {
                ans[0]=i;
            }
        }
        return ans;
    }
}