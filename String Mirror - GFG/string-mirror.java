//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String str;
            str = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.stringMirror(str);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String stringMirror(String str) {
        StringBuilder ans=new StringBuilder();
        String prefix="";
        int prev=-1;
        for(int i=0;i<str.length();i++)
        {
            if(ans.length()==0)
            {
                ans.append(str.charAt(i));
                prefix+=str.charAt(i);
                prev=(int)(str.charAt(i));
                continue;
            }
            prefix+=str.charAt(i);
            if((int)(str.charAt(i))<prev)
            {
                ans=new StringBuilder(prefix);
                prev=str.charAt(i);
            }
            else if((int)(str.charAt(i))==prev && i>1)
            {
                 ans=new StringBuilder(prefix);
                prev=str.charAt(i);
            }
            else
            {
                break;
            }
        }
        String a1=new String(ans);
        String a2=new String(ans.reverse());
        return a1+a2;
    }
}
        
