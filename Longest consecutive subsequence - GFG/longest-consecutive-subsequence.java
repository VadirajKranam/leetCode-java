//{ Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
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
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			
			for(int i=0; i<n; i++)
				a[i] = sc.nextInt();
		    out.println(new Solution().findLongestConseqSubseq(a, n));
		    t--;
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	     int max=0;
	     for(int i=0;i<arr.length;i++)
	     {
	         max=Math.max(max,arr[i]);
	     }
	     int[] t=new int[max+1];
	     Arrays.fill(t,-1);
	     for(int i=0;i<arr.length;i++)
	     {
	         t[arr[i]]=1;
	     }
	     int maxLen=0;
	     int curLen=0;
	     for(int i=0;i<t.length;i++)
	     {
	         if(t[i]!=-1)
	         {
	             curLen++;
	         }
	         else
	         {
	             maxLen=Math.max(maxLen,curLen);
	             curLen=0;
	         }
	     }
	     maxLen=Math.max(maxLen,curLen);
	     return maxLen;
	}
}