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
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            boolean ans = obj.isStraightHand(n, k, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        if(N%groupSize!=0)
        {
            return false;
        }
        SortedMap<Integer,Integer> s=new TreeMap<>();
        for(int i=0;i<hand.length;i++)
        {
            s.put(hand[i],s.getOrDefault(hand[i],0)+1);
        }
        int num=-1;
        int c=0;
        while(true)
        {
            num=s.firstKey();
            c=0;
            while(c<groupSize)
            {
                if(s.get(num)==null)
                {
                    return false;
                }
                s.put(num,s.get(num)-1);
                if(s.get(num)==0)
                {
                    s.remove(num);
                }
                num++;
                c++;
            }
            if(s.size()==0)
            {
                break;
            }
        }
        return true;
    }
}
