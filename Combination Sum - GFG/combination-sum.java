//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void main (String[] args)throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-- >0)
        {
            String str[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            ArrayList<Integer> list = new ArrayList<>();
            str = br.readLine().trim().split(" ");
            for(int i = 0; i <n ;i++)
                list.add(Integer.parseInt(str[i]));
            str = br.readLine().trim().split(" ");    
            int sum = Integer.parseInt(str[0]);
            
            Solution ob = new Solution();
            
            res = ob.combinationSum(list, sum);
            if (res.size() == 0) {
    			out.print("Empty");
    		}
 
    		// Print all combinations stored in res.
    		for (int i = 0; i < res.size(); i++) {
    			if (res.size() > 0) {
    				out.print("(");
    				List<Integer> ij = res.get(i);
    				for (int j = 0; j < ij.size(); j++) {
    				    
    					out.print(ij.get(j));
    					if(j < ij.size()-1)
    					 out.print(" ");
    				}
    				out.print(")");
    			}
    		}
    		out.println();
    		res.clear();
	    }
	    out.flush();
    }
    
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to return a list of indexes denoting the required 
    //combinations whose sum is equal to given number.
    static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
       Collections.sort(A);
       Set<Integer> s=new HashSet<>(A);
       int[] temp=new int[s.size()];
       int k=0;
       for(int l:s)
       {
           temp[k++]=l;
       }
       ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
       ArrayList<Integer> t=new ArrayList<>();
       function(0,temp,ans,t,B);
       return ans;
    }
    static void function(int i,int[] temp,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> t,int target)
    {
        if(i==temp.length && target==0)
        {
            //t.add(temp[i]);
            ans.add(new ArrayList<>(t));
            return;
        }
        if(i>=temp.length)
        {
            return;
        }
        if(temp[i]<=target)
        {
            t.add(temp[i]);
            Collections.sort(t);
            function(i,temp,ans,t,target-temp[i]);
            t.remove(t.size()-1);
        }
        function(i+1,temp,ans,t,target);
    }
}