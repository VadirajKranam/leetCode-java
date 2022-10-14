//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    Arrays.sort(arr);
		    Complete obj = new Complete();
		    int ans = obj.maximizeSum(arr, sizeOfArray);
		    System.out.println(ans);
		}
	}
}




// } Driver Code Ends


//User function Template for Java



class Complete{
    
   
    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        if(arr.length==1)
        {
            return arr[0];
        }
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(m.get(arr[i])==null)
            {
                m.put(arr[i],1);
            }
            else
            {
                m.put(arr[i],m.get(arr[i])+1);
            }
        }
        int sum=0;
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--)
        {
            int k1=arr[i];
            if(m.get(k1)==0)
            {
                continue;
            }
            if(m.get(k1-1)!=null && m.get(k1-1)!=0)
            {
                m.put(k1-1,m.get(k1-1)-1);
                m.put(k1,m.get(k1)-1);
                sum+=k1;
                continue;
            }
            while(m.get(k1)!=0)
            {
                sum+=k1;
                m.put(k1,m.get(k1)-1);
            }
        }
        return sum;
    }
    
    
}


