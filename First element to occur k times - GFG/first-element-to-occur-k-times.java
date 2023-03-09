//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class GfG { 
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    int[] arr = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++)arr[i] = Integer.parseInt(inputLine[i]);
		    
		    Solution obj = new Solution();
		    System.out.println(obj.firstElementKTime(arr, n, m));
		}
	}
}

// } Driver Code Ends


class Solution
{
    public int firstElementKTime(int[] a, int n, int k) { 
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<a.length;i++)
        {
            if(m.get(a[i])!=null)
            {
                m.put(a[i],m.get(a[i])+1);
            }
            if(m.get(a[i])==null)
            {
                m.put(a[i],1);
            }
            if(m.get(a[i])==k)
            {
                return a[i];
            }
        }
        return -1;
    } 
}