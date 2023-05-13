//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        int[] m=new int[n*2];
        int i=0,j=0,k=0;
        while(i<ar1.length && j<ar2.length)
        {
            if(ar1[i]<ar2[j])
            {
                m[k]=ar1[i];
                i++;
            }
            else
            {
                m[k]=ar2[j];
                j++;
            }
            k++;
        }
        while(i<ar1.length)
        {
            m[k]=ar1[i];
            i++;
            k++;
        }
        while(j<ar2.length)
        {
            m[k]=ar2[j];
            j++;
            k++;
        }
        return m[m.length/2-1]+m[m.length/2];
    }
}