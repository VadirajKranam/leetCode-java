//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        Map<Integer,Integer> m1=new HashMap<>();
        Map<Integer,Integer> m2=new HashMap<>();
        for(int i=0;i<arr1.length;i++)
        {
            if(m1.get(arr1[i])==null)
            {
                m1.put(arr1[i],1);
            }
            else
            {
                m1.put(arr1[i],m1.get(arr1[i])+1);
            }
        }
        for(int i=0;i<arr2.length;i++)
        {
            if(m2.get(arr2[i])==null)
            {
                m2.put(arr2[i],1);
            }
            else
            {
                m2.put(arr2[i],m2.get(arr2[i])+1);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length)
        {
            if(arr1[i]==arr2[j])
            {
                ans.add(arr1[i]);
                i+=m1.get(arr1[i]);
                j+=m2.get(arr2[j]);
            }
            else if(arr1[i]<arr2[j])
            {
                ans.add(arr1[i]);
                i+=m1.get(arr1[i]);
            }
            else
            {
                ans.add(arr2[j]);
                j+=m2.get(arr2[j]);
            }
        }
        while(i<arr1.length)
        {
            ans.add(arr1[i]);
            i+=m1.get(arr1[i]);
        }
        while(j<arr2.length)
        {
            ans.add(arr2[j]);
            j+=m2.get(arr2[j]);
        }
        return ans;
    }
}



