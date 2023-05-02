//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] s, int N, int k) {
	    int min=Integer.MAX_VALUE;
	    int sum=0;
	    for(int i=0;i<s.length;i++)
	    {
	        sum+=s[i];
	        min=Math.min(s[i],min);
	    }
	    int l=min;
	    int h=sum;
	    int ans=0;
	    while(l<=h)
	    {
	        int mid=(l+h)/2;
	        if(isPos(s,mid,k))
	        {
	            ans=mid;
	            l=mid+1;
	        }
	        else
	        {
	            h=mid-1;
	        }
	    }
	    return ans;
	}
	boolean isPos(int[] s,int mid,int k)
	{
	    int sum=0;
	    int cnt=0;
	    for(int i=0;i<s.length;i++)
	    {
	        sum+=s[i];
	        if(sum>=mid)
	        {
	            cnt++;
	            sum=0;
	        }
	    }
	    return cnt>=k+1;
	}
}