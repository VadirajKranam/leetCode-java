//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] Intervals)
    {
        Arrays.sort(Intervals,new Comparator<int[]>(){
           @Override
           public int compare(int[] a,int[] b)
           {
               if(a[0]>b[0])
               {
                   return 1;
               }
               return -1;
           }
        });
       ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
       ans.add(new ArrayList<>());
       ans.get(0).add(Intervals[0][0]);
       ans.get(0).add(Intervals[0][1]);
       for(int i=1;i<Intervals.length;i++)
       {
           if(Intervals[i][0]<=ans.get(ans.size()-1).get(1))
           {
               ans.get(ans.size()-1).set(1,Math.max(ans.get(ans.size()-1).get(1),Intervals[i][1]));
           }
           else
           {
               ans.add(new ArrayList<>());
               ans.get(ans.size()-1).add(Intervals[i][0]);
               ans.get(ans.size()-1).add(Intervals[i][1]);
           }
       }
      int[][] ans2=new int[ans.size()][2];
      for(int i=0;i<ans.size();i++)
      {
          ans2[i][0]=ans.get(i).get(0);
          ans2[i][1]=ans.get(i).get(1);
      }
      return ans2;
    }
}