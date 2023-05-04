//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String args[])throws IOException
    {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int a[][]=new int[n][3];
                for(int i=0;i<n;i++){
                    String s[]=in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception e){
            ;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int maxCoins(int n,int ranges[][])
    {
        Arrays.sort(ranges,new Comparator<int[]>(){
           @Override
           public int compare(int[] a,int[] b)
           {
              
               if(a[0]==b[0])
               {
                  return a[1]-b[1]; 
               }
               return a[0]-b[0];
           }
        });
      int[] maxProfit=new int[ranges.length];
      int max=-1;
      maxProfit[maxProfit.length-1]=ranges[ranges.length-1][2];
      for(int i=ranges.length-2;i>=0;i--)
      {
         maxProfit[i]=Math.max(maxProfit[i+1],ranges[i][2]);
      }
      int cost=Integer.MIN_VALUE;
      for(int i=0;i<ranges.length;i++)
      {
          int l=i+1,h=ranges.length-1,t=0;
          while(l<=h)
          {
              int mid=(l+h)/2;
              if(ranges[mid][0]>=ranges[i][1])
              {
                  h=mid-1;
                 t=maxProfit[mid]; 
                  
              }
              else
              {
                 
                l=mid+1;  
                  
              }
          }
          int curCost=ranges[i][2]+t;
          cost=Math.max(cost,curCost);
      }
        return cost;
    }
}