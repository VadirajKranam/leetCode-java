//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        int[] prefix=new int[arr.length];
        int[] suffix=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            prefix[i]=Math.max(prefix[i-1],arr[i]);
        }
        suffix[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            suffix[i]=Math.max(suffix[i+1],arr[i]);
        }
        long waterTrapped=0;
        for(int i=0;i<arr.length;i++)
        {
            waterTrapped+=Math.min(prefix[i],suffix[i])-arr[i];
        }
        return waterTrapped;
    } 
}


