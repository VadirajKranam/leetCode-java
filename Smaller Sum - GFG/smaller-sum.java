//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine());
            String s[]=in.readLine().trim().split(" ");
            int a[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=Integer.parseInt(s[i]);
            }
            Solution ob=new Solution();
            long ans[]=ob.smallerSum(n,a);
            for(long i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    public long[] smallerSum(int n,int arr[])
    {
        Map<Integer,Long> m=new HashMap<>();
        int[] temp=Arrays.copyOf(arr,arr.length);
        Arrays.sort(arr);
        long sum=0;
        m.put(arr[0],0l);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
            {
                sum+=arr[i-1];
                //m.put(arr[i],sum);
                continue;
            }
            sum+=arr[i-1];
            m.put(arr[i],sum);
        }
    
        long[] ans=new long[arr.length];
        for(int i=0;i<temp.length;i++)
        {
            ans[i]=m.get(temp[i]);
            //System.out.println(temp[i]+" : "+m.get(temp[i]));
        }
         return ans;
    }
}