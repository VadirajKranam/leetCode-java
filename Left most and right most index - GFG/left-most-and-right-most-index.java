//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        int index=-1;
        int i=0,j=v.length-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(v[mid]==x)
            {
                index=mid;
                break;
            }
            else if(v[mid]>x)
            {
                j=mid-1;
            }
            else
            {
                i=mid+1;
            }
        }
        if(index==-1)
        {
            return new pair(-1,-1);
        }
        int li=index;
        while(li>=0 && v[li]==x)
        {
            li--;
        }
        int ri=index;
        while(ri<v.length && v[ri]==x)
        {
            ri++;
        }
        return new pair(li+1,ri-1);
    }
}