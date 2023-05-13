//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		
	    while(t-- >0)
	    {
	        String inputLine[] = br.readLine().trim().split(" ");
	        
	        //taking n and sum
            int n = Integer.parseInt(inputLine[0]);
            int sum = Integer.parseInt(inputLine[1]);
            
            //calling largestNumber() function
            System.out.println(new Solution().largestNumber(n, sum));
	    }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to return the largest possible number of n digits
    //with sum equal to given sum.
    static String largestNumber(int n, int sum)
    {
        int k=sum;
        StringBuilder ans=new StringBuilder();
        int num=9;
        while(sum>0 && n>0)
        {
           while(num>sum)
           {
               num--;
           }
           sum=sum-num;
           ans.append(num+"");
           n--;
        }
        while(n>0)
        {
            ans.append("0");
            n--;
        }
        if(checkSum(ans)==k)
        {
            return ans.toString();
        }
        return "-1";
    }
    static int checkSum(StringBuilder a)
    {
        int sum=0;
        for(int i=0;i<a.length();i++)
        {
            sum+=(a.charAt(i)-'0');
        }
        return sum;
    }
}


