//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
        int max=-1;
        for(int i=0;i<interval.length;i++)
        {
            max=Math.max(max,interval[i][1]);
        }
        int[] arr=new int[max+3];
        Arrays.fill(arr,0);
        for(int i=0;i<interval.length;i++)
        {
            arr[interval[i][0]]++;
            arr[interval[i][1]+1]--;
        }
        int[] prefix=new int[arr.length];
        Arrays.fill(prefix,0);
        int sum=0;
        for(int i=0;i<prefix.length;i++)
        {
            sum+=arr[i];
            prefix[i]=sum;
            
        }
        int maxNum=-1;
        for(int i=0;i<prefix.length;i++)
        {
            if(prefix[i]>=k)
            {
                maxNum=Math.max(maxNum,i);
            }
        }
        return maxNum;
    }
}