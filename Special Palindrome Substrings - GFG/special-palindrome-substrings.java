//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0)
		{
		    String str = br.readLine();
		    String s1 = str.split(" ")[0];
		    String s2 = str.split(" ")[1];
		    
		    Solution obj = new Solution();
		    int ans = obj.specialPalindrome(s1,s2);
		    System.out.println(ans);
		    
		    
		    
		}
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
    public  static int specialPalindrome(String a, String b){
       if(a.length()<b.length())
       {
           return -1;
       }
       int ans=Integer.MAX_VALUE;
       int n1=a.length(),n2=b.length();
       char[] s1=a.toCharArray();
       char[] s2=b.toCharArray();
       for(int i=0;i<n1-n2+1;i++)
       {
           char[] temp=(a.substring(0,i)+b+a.substring(i+n2)).toCharArray();
           int cost=0;
           //System.out.println(Arrays.toString(temp));
           for(int j=i;j<i+n2;j++)
           {
               if(s1[j]!=temp[j])
               {
                   cost++;
               }
           }
           int is_palin=1;
           for(int j=0;j<Math.ceil(n1/2.0);j++)
           {
               if((j<i || j>=i+n2) && temp[j]!=temp[n1-j-1])
               {
                   cost++;
               }
               else if((n1-i-1<j || n1-i-n2-1>=j) && temp[j]!=temp[n1-j-1])
               {
                   cost++;
               }
               else if(temp[j]!=temp[n1-j-1])
               {
                   is_palin=0;
                   break;
               }
           }
           if(is_palin==1)
           {
               ans=Math.min(ans,cost);
           }
       }
       if(ans==Integer.MAX_VALUE)
       {
           return -1;
       }
       return ans;
     }
}