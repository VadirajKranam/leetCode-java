//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String s[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int a[] = new int[n];
			s = br.readLine().trim().split(" ");
			for(int i = 0; i < n; i++)
				a[i] = Integer.parseInt(s[i]);
			List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
			for(List<Integer> list : ans){
				for(int x : list)
					ot.print(x + " ");
				ot.println();
			}
			if(ans.size() == 0)
			    ot.println();
		}
        ot.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	public List<List<Integer>> CombinationSum2(int a[], int n, int k){
		List<List<Integer>> ans=new ArrayList<>();
		List<Integer> t=new ArrayList<>();
		Arrays.sort(a);
		function(0,a,ans,t,k);
		return ans;
	}
	public void function(int ind,int[] a,List<List<Integer>> ans,List<Integer> t,int target)
	{
	    if(target==0)
	    {
	        ans.add(new ArrayList<>(t));
	    }
	    for(int i=ind;i<a.length;i++)
	    {
	        if(i>ind && a[i]==a[i-1])
	        {
	            continue;
	        }
	        if(a[i]>target)
	        {
	            break;
	        }
	        t.add(a[i]);
	        function(i+1,a,ans,t,target-a[i]);
	        t.remove(t.size()-1);
	    }
	}
}

