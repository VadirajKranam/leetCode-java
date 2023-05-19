//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        
        while(t-- > 0){
            int n=Integer.parseInt(in.readLine().trim());
            int range[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                range[i][0]=Integer.parseInt(s[0]);
                range[i][1]=Integer.parseInt(s[1]);
            }
            int q=Integer.parseInt(in.readLine().trim());
            int Q[]=new int[q];
            String s[]=in.readLine().trim().split(" ");
            for(int i=0;i<q;i++){
                Q[i]=Integer.parseInt(s[i]);
            }

            Solution ob=new Solution();
            ArrayList<Integer> ans=ob.kthSmallestNum(n, range, q, Q);

            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    } 
}
// } Driver Code Ends

class Pair{
    int s,e;
    Pair(int s,int e)
    {
        this.s=s;
        this.e=e;
    }
}
class Solution {
    public static ArrayList<Integer> kthSmallestNum(int n, int[][] range, int q, int[] queries) {
        ArrayList<Pair> m=new ArrayList<>();
        Arrays.sort(range,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
            {
                if(a[0]>b[0])
                {
                    return 1;
                }
                else
                {
                    return -1;
                }
            }
        });
       int index=0;
        m.add(new Pair(range[0][0],range[0][1]));
        for(int i=1;i<range.length;i++)
        {
            if(range[i][0]<m.get(m.size()-1).e)
            {
                Pair t=new Pair(m.get(m.size()-1).s,Math.max(m.get(m.size()-1).e,range[i][1]));
                m.set(m.size()-1,t);
            }
            else
            {
                m.add(new Pair(range[i][0],range[i][1]));
                index=m.size()-1;
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
           int an=-1;
           int k=queries[i];
           for(int j=0;j<=index;j++)
           {
               if(k<=Math.abs(m.get(j).e-m.get(j).s+1))
               {
                   an=m.get(j).s+k-1;
                   break;
               }
               k=k-Math.abs(m.get(j).e-m.get(j).s+1);
           }
           ans.add(an);
        }
        return ans;
    }
}
        
