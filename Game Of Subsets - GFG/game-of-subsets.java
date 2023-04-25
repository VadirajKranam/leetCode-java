//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.goodSubsets(a, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public int goodSubsets(int[] arr, int n) {
        int[] mm=new int[31];
        mm[2]=1;
        mm[3]=2;
        mm[5]=4;
        mm[6]=3;
        mm[7]=8;
        mm[10]=5;
        mm[11]=16;
        mm[13]=32;
        mm[14]=9;
        mm[15]=6;
        mm[17]=64;
        mm[19]=128;
        mm[21]=10;
        mm[22]=17;
        mm[23]=256;
        mm[26]=33;
        mm[29]=512;
        mm[30]=7;
        Map<Integer,Integer> f=new HashMap<>();
        int c=0;
        for(int a:arr)
        {
            if(a==1)
            {
                c++;
            }
            else if(f.get(a)==null)
            {
                f.put(a,1);
            }
            else
            {
                f.put(a,f.get(a)+1);
            }
        }
        long[] dp=new long[1024];
        Arrays.fill(dp,0l);
        dp[0]=1l;
        int mod=(int)(1e9+7);
       for(Map.Entry<Integer,Integer> e:f.entrySet())
       {
           if(mm[e.getKey()]!=0)
           {
               for(int i=0;i<1024;i++)
               {
                   if((mm[e.getKey()]&i)==0)
                   {
                       dp[(mm[e.getKey()]|i)]+=(e.getValue()*dp[i]);
                       dp[(mm[e.getKey()]|i)]%=mod;
                   }
               }
               
           }
       }
       long ans=0;
       for(int i=1;i<1024;i++)
       {
           ans+=dp[i];
           ans%=mod;
       }
       while(c>0)
       {
           ans*=2;
           ans%=mod;
           c--;
       }
       return (int)ans;
    }
};