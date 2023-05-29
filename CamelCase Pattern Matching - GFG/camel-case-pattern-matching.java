//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
       ArrayList<String> patterns=new ArrayList<>();
       for(int i=0;i<Dictionary.length;i++)
       {
           StringBuilder s=new StringBuilder();
           for(int j=0;j<Dictionary[i].length();j++)
           {
               if(Dictionary[i].charAt(j)>='A' && Dictionary[i].charAt(j)<='Z')
               {
                   s.append(Dictionary[i].charAt(j));
               }
               
           }
           patterns.add(s.toString());
       }
       ArrayList<String> ans=new ArrayList<>();
       for(int i=0;i<patterns.size();i++)
       {
           if(patterns.get(i).startsWith(Pattern))
           {
               ans.add(Dictionary[i]);
           }
       }
       if(ans.size()==0)
       {
           ans.add("-1");
           return ans;
       }
       Collections.sort(ans);
       return ans;
       
    }
}