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

            ArrayList<Long> ans = new Solution().nthRowOfPascalTriangle(n);
            printAns(ans);
        }
    }
    public static void printAns(ArrayList<Long> ans) {
        for (Long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<ArrayList<Long>> tr=new ArrayList<>();
        ArrayList<Long> f=new ArrayList<>();
        f.add(1l);
        tr.add(f);
        for(int i=1;i<n;i++)
        {
            ArrayList<Long> in=new ArrayList<>();
            in.add(1l);
            for(int j=1;j<i;j++)
            {
                long num=(tr.get(i-1).get(j-1)+tr.get(i-1).get(j))%1000000007;
                in.add(num);
            }
            in.add(1l);
            tr.add(in);
        }
        return tr.get(n-1);
    }
}