//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    Long maxTripletProduct(Long arr[], int n)
    {
       Long mx1=Long.MIN_VALUE,mx2=Long.MIN_VALUE,mx3=Long.MIN_VALUE;
       Long mn1=Long.MAX_VALUE,mn2=Long.MAX_VALUE;
       for(int i=0;i<arr.length;i++)
       {
           if(arr[i]>mx1)
           {
               Long t1=mx1;
               mx1=arr[i];
               Long t2=mx2;
               mx2=t1;
               mx3=t2;
           }
           else if(arr[i]>mx2)
           {
               Long t=mx2;
               mx2=arr[i];
               mx3=t;
           }
           else if(arr[i]>mx3)
           {
               mx3=arr[i];
           }
           if(arr[i]<mn1)
           {
               Long t=mn1;
               mn1=arr[i];
               mn2=t;
           }
           else if(arr[i]<mn2)
           {
               mn2=arr[i];
           }
       }
       return Math.max((mx1*mx2*mx3),(mn1*mn2*mx1));
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    int sizeOfArray = Integer.parseInt(br.readLine());
		    
		    Long[] arr = new Long[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Long.parseLong(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    Long res = obj.maxTripletProduct(arr, sizeOfArray);
		    System.out.println(res);
		}
	}
}


// } Driver Code Ends