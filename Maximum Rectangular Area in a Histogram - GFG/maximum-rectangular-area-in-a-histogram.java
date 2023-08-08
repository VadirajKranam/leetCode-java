//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        long[] ls=new long[hist.length];
        long[] rs=new long[hist.length];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<hist.length;i++)
        {
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ls[i]=0;
            }
            else
            {
                ls[i]=st.peek()+1;
            }
            st.push(i);
        }
       while(!st.isEmpty())
       {
           st.pop();
       }
         for(int i=hist.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && hist[st.peek()]>=hist[i])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                rs[i]=hist.length-1;
            }
            else
            {
                rs[i]=st.peek()-1;
            }
            st.push(i);
        }
       long maxA=0;
       for(int i=0;i<ls.length;i++)
       {
           maxA=Math.max(maxA,hist[i]*(rs[i]-ls[i]+1));
       }
       return maxA;
    }
        
}



