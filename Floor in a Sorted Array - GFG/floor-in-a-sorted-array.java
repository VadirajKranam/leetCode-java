//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Searching
{
    public static void main (String[] args)throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
           String a[] = read.readLine().trim().split("\\s+");
           int n = Integer.parseInt(a[0]);
           long x = Long.parseLong(a[(int)1]);
           String st[] = read.readLine().trim().split("\\s+");
        
           long arr[] = new long[n];
           for(int i = 0; i < n; i++)
           {
               arr[i] = Long.parseLong(st[i]);
           }
           
           out.println(new Solution().findFloor(arr, n, x));
          
        }
        out.close();
    }
    
}
// } Driver Code Ends


class Solution{
    
    // Function to find floor of x
    // arr: input array
    // n is the size of array
    static int findFloor(long arr[], int n, long x)
    {
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(x==arr[mid])
            {
                return mid;
            }
            else if(x>arr[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        //System.out.println(arr[low]+" "+arr[high]);
        if(high<0)
        {
            return -1;
        }
        
        return high;
    }
    
}
