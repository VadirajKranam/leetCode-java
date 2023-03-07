//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr, n);
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
    void pushZerosToEnd(int[] arr, int n) {
      int[] ans=new int[arr.length];
      int k=0;
      for(int i=0;i<arr.length;i++)
      {
          if(arr[i]!=0)
          {
              ans[k]=arr[i];
              k++;
          }
      }
      while(k<arr.length)
      {
          ans[k]=0;
          k++;
      }
      for(int i=0;i<ans.length;i++)
      {
          arr[i]=ans[i];
      }
    }
    
}