//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestChain(int N, String words[]){
        Arrays.sort(words,Comparator.comparing(s->s.length()));
     int[] dp=new int[words.length];
     Arrays.fill(dp,1);
     int[] hash=new int[words.length];
     Arrays.fill(hash,1);
     int max=0;
     for(int i=0;i<words.length;i++)
     {
         hash[i]=i;
         for(int pi=0;pi<i;pi++)
         {
             if(check(words[i],words[pi]) && 1+dp[pi]>dp[i])
             {
                 dp[i]=1+dp[pi];
             }
         }
         if(dp[i]>max)
         {
             max=dp[i];
         }
     }
     return max;
    }
    public boolean check(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1)
        {
            return false;
        }
        int f=0,s=0;
        while(f<s1.length())
        {
            if(s<s2.length() && s1.charAt(f)==s2.charAt(s))
            {
                f++;
                s++;
            }
            else
            {
                f++;
            }
        }
        if(f==s1.length() && s==s2.length())
        {
            return true;
        }
        return false;
    }
}