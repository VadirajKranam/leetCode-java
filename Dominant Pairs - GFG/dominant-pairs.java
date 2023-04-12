//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.dominantPairs(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int dominantPairs(int n, int[] arr) {
        int[] a1=new int[arr.length/2];
        int[] a2=new int[arr.length/2];
        for(int i=0;i<arr.length/2;i++)
        {
            a1[i]=arr[i];
        }
        for(int i=arr.length/2;i<arr.length;i++)
        {
            a2[i-arr.length/2]=arr[i];
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i=a1.length-1;
        int j=a2.length-1;
        int count=0;
        while(i>=0)
        {
            while(j>=0 && a1[i]<a2[j]*5)
            {
                j--;
            }
            count+=(j+1);
            i--;
        }
        return count;
    }
}
        
