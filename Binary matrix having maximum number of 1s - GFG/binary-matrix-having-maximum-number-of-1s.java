//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class FastReader{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader(){ 
        br = new BufferedReader(new InputStreamReader(System.in)); 
    } 

    String next(){ 
        while (st == null || !st.hasMoreElements()){ 
            try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
        } 
        return st.nextToken(); 
    } 

    String nextLine(){ 
        String str = ""; 
        try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
        return str; 
    } 
    
    Integer nextInt(){
        return Integer.parseInt(next());
    }
} 

class GfG {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0) {
            int B = sc.nextInt();
            int arr[][] = new int[B][B];
            for(int i = 0; i < B; i++) {
                for(int j = 0; j < B; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int ans[] = obj.findMaxRow(arr, B);
            for(int i = 0; i < 2; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int[] findMaxRow(int mat[][], int N) {
         int max1=Integer.MIN_VALUE;
         int ans=0;
         for(int i=0;i<mat.length;i++)
         {
             int num1=0;
             for(int j=0;j<mat[i].length;j++)
             {
                 if(mat[i][j]==1)
                 {
                     num1=mat[0].length-j;
                     break;
                 }
             }
             if(num1>max1)
             {
                 max1=num1;
                 ans=i;
             }
         }
         return new int[]{ans,max1};
    }
};