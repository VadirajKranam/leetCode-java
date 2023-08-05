//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public ArrayList<String> permutation(String S)
    {
       char[] temp=S.toCharArray();
       ArrayList<String> ans=new ArrayList<>();
       function(0,temp,ans);
       Collections.sort(ans);
       return ans;
    }
	public void function(int i,char[] temp,ArrayList<String> ans)
	{
	    if(i>=temp.length)
	    {
	        String t=new String(temp);
	        ans.add(t);
	        return;
	    }
	    for(int j=i;j<temp.length;j++)
	    {
	        swap(temp,i,j);
	        function(i+1,temp,ans);
	        swap(temp,i,j);
	    }
	}
	public void swap(char[] temp,int i1,int i2)
	{
	    char t=temp[i1];
	    temp[i1]=temp[i2];
	    temp[i2]=t;
	}
}
