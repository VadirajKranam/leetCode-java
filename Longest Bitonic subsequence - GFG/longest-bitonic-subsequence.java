//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];
        Arrays.fill(dp1,1);
        Arrays.fill(dp2,1);
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]>nums[j] && (1+dp1[j])>dp1[i])
                {
                    dp1[i]=1+dp1[j];
                }
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            for(int j=nums.length-1;j>i;j--)
            {
                 if(nums[i]>nums[j] && (1+dp2[j])>dp2[i])
                {
                    dp2[i]=1+dp2[j];
                }
            }
        }
        int max=1;
        for(int i=0;i<nums.length;i++)
        {
            max=Math.max(max,(dp1[i]+dp2[i]-1));
        }
        return max;
    }
}