//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<0)
            {
                neg.add(arr[i]);
            }
            else
            {
                pos.add(arr[i]);
            }
        }
        ArrayList<Integer> ar=new ArrayList<>();
        boolean c=true;
        int i=0,j=0;
        while(i<pos.size() && j<neg.size())
        {
            if(c)
            {
                ar.add(pos.get(i));
                i++;
                c=false;
            }
            else
            {
                ar.add(neg.get(j));
                j++;
                c=true;
            }
        }
        while(i<pos.size())
        {
           ar.add(pos.get(i));
                i++; 
        }
        while(j<neg.size())
        {
            ar.add(neg.get(j));
            j++;
        }
        for(int h=0;h<ar.size();h++)
        {
            arr[h]=ar.get(h);
        }
    }
}