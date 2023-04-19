//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int K;
            K = sc.nextInt();

            int N;
            N = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> ans = obj.combinationSum(K, N);
            Collections.sort(ans, new Comparator<ArrayList<Integer>>() {
                @Override   public int compare(ArrayList<Integer> a,
                                             ArrayList<Integer> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        if (a.get(i) < b.get(i))
                            return -1;
                        else if (a.get(i) > b.get(i))
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
            for (int i = 0; i < ans.size(); i++) {
                ArrayList<Integer> cur = ans.get(i);
                for (int j = 0; j < cur.size(); j++) {
                    System.out.print(cur.get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<ArrayList<Integer>> combinationSum(int K, int N) {
        int[] nums=new int[9];
        for(int i=0;i<nums.length;i++)
        {
            nums[i]=i+1;
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ArrayList<Integer> d=new ArrayList<>();
        function(0,nums,K,N,ans,d);
        return ans;
    }
    public static void function(int i,int[] nums,int len,int sum,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> d)
    {
        if(i==nums.length && sum==0 && d.size()==len)
        {
            ans.add(new ArrayList<>(d));
        }
        if(i>=nums.length)
        {
            return;
        }
        if(nums[i]<=sum)
        {
            d.add(nums[i]);
            function(i+1,nums,len,sum-nums[i],ans,d);
            d.remove(d.size()-1);
        }
        function(i+1,nums,len,sum,ans,d);
    }
}