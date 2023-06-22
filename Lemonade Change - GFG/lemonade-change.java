//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        int f=0;
        int t=0;
        int tw=0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i]==5)
            {
                f++;
            }
            else if(bills[i]==10)
            {
               if(f>=1)
               {
                   f=f-1;
                   t++;
               }
               else
               {
                   return false;
               }
            }
            else if(bills[i]==20)
            {
                if(t>=1 && f>=1)
                {
                    t=t-1;
                    f=f-1;
                    tw++;
                }
                else if(f>=3)
                {
                    f=f-3;
                    tw++;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}
