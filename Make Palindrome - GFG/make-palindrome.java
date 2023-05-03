//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.makePalindrome(n, arr);
            
            String _result_val = (res) ? "YES" : "NO";
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static boolean makePalindrome(int n, String[] arr) {
       Map<String,Integer> m=new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
           StringBuilder t=new StringBuilder(arr[i]);
           t=t.reverse();
           String s=new String(t);
           if(m.get(s)!=null)
           {
               m.put(s,m.get(s)-1);
               if(m.get(s)==0)
               {
                   m.remove(s);
               }
           }
           else
           {
               m.put(arr[i],1);
           }
       }
       if(m.size()==0)
       {
           return true;
       }
       if(m.size()==1)
       {
           for(Map.Entry<String,Integer> e:m.entrySet())
           {
               return isPallindrome(e.getKey());
           }
       }
       return false;
    }
    public static boolean isPallindrome(String s)
    {
        StringBuilder t=new StringBuilder(s);
        t=t.reverse();
        String s2=new String(t);
        return s.equals(s2);
    }
}
        
