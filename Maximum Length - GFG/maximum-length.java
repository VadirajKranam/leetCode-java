//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    }
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 
    
class GFG {
    public static void main(String args[]) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
    
            Solution ob = new Solution();
            int ans = ob.solve(a, b, c);
            
            out.println(ans);
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int solve(int a, int b, int c) {
        int[] freq={a,b,c};
        char prev='0';
        StringBuilder ans=new StringBuilder();
        while(true)
        {
            int ma=0;
            char cur=' ';
            for(int i=0;i<3;i++){
                if(prev!=(char)(i+'a') && ma<freq[i]){
                    ma=freq[i];
                    cur=(char)(i+'a');
                }
            }
                if(ma==0)
                {
                    break;
                }
                ans.append(String.valueOf(cur));
                freq[cur-'a']--;
                if(ma>=2 && (prev=='0' ||ma>=freq[prev-'a']))
                {
                    ans.append(String.valueOf(cur));
                    freq[cur-'a']--;
                }
                prev=cur;
            
        }
        int n=a+b+c;
        if(n!=ans.length())
        {
            return -1;
        }
        return n;
    }
};








