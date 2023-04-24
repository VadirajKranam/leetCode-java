//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int [] arr = new int[n];
			String [] str = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(str[i]);
			Solution ob = new Solution();
			int [] ans = ob.nearestSmallestTower(arr);
			for(int i = 0; i < n; i++)
				System.out.print(ans[i]+" ");
			System.out.println();
		}
		
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution{
	int [] nearestSmallestTower(int [] arr){
	    int[] res=new int[arr.length];
	    Arrays.fill(res,-1);
		Stack<Integer> l=new Stack<>();
		Stack<Integer> r=new Stack<>();
		for(int i=0;i<arr.length;i++)
		{
		    if(l.isEmpty())
		    {
		        l.push(i);
		    }
		    else if(arr[l.peek()]<arr[i])
		    {
		        res[i]=l.peek();
		        l.push(i);
		    }
		    else
		    {
		        while(!l.isEmpty() && arr[l.peek()]>=arr[i])
		        {
		            l.pop();
		        }
		        if(!l.isEmpty())
		        {
		            res[i]=l.peek();
		        }
		        l.push(i);
		    }
		}
		for(int i=arr.length-1;i>=0;i--)
		{
		    if(r.isEmpty())
		    {
		        r.push(i);
		    }
		    else if(arr[r.peek()]<arr[i])
		    {
		        if(res[i]==-1){
		        res[i]=r.peek();
		        r.push(i);
		        }
		        else if(Math.abs(res[i]-i)==Math.abs(r.peek()-i))
		        {
		            if(arr[res[i]]>arr[r.peek()])
		            {
		                res[i]=r.peek();
		            }
		        }
		        else if(Math.abs(res[i]-i)>Math.abs(r.peek()-i))
		        {
		            res[i]=r.peek();
		        }
		    }
		    else
		    {
		        while(!r.isEmpty() && arr[r.peek()]>=arr[i])
		        {
		            r.pop();
		        }
		        if(!r.isEmpty())
		        {
		            if(res[i]==-1){
		        res[i]=r.peek();
		        r.push(i);
		        }
		        else if(Math.abs(res[i]-i)==Math.abs(r.peek()-i))
		        {
		            if(arr[res[i]]>arr[r.peek()])
		            {
		                res[i]=r.peek();
		            }
		        }
		        else if(Math.abs(res[i]-i)>Math.abs(r.peek()-i))
		        {
		            res[i]=r.peek();
		        }
		       }
		        
		    }
		    r.push(i);
		}
		return res;
	}
}