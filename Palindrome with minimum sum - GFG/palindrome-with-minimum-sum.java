//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            int res = obj.minimumSum(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumSum(String s) {
       int i=0,j=s.length()-1;
       int ans=0;
       char prev='#';
       while(i<=j)
       {
           if(s.charAt(i)=='?' && s.charAt(j)=='?')
           {
               if(prev=='#')
               {
                   prev=help(s);
                   if(prev=='#')
                   {
                       return 0;
                   }
               }
           }
           else if(s.charAt(i)=='?')
           {
               if(prev!='#')
               {
                   ans+=2*Math.abs(prev-s.charAt(j));
               }
               prev=s.charAt(j);
           }
           else if(s.charAt(j)=='?')
           {
               if(prev!='#')
               {
                   ans+=2*Math.abs(prev-s.charAt(i));
               }
               prev=s.charAt(i);
           }
           else if(s.charAt(i)==s.charAt(j))
           {
               if(prev!='#')
               {
                   ans+=2*Math.abs(prev-s.charAt(i));
               }
               prev=s.charAt(i);
           }
           else
           {
               return -1;
           }
           i++;
           j--;
       }
       return ans;
    }
    public static char help(String s)
    {
        int i=0,j=s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i)!='?')
            {
                return s.charAt(i);
            }
            else if(s.charAt(j)!='?')
            {
                return s.charAt(j);
            }
            i++;
            j--;
        }
        return '#';
    }
}
