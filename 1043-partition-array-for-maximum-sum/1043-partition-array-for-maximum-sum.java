class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp=new int[arr.length+1];
        Arrays.fill(dp,0);
        for(int i=arr.length-1;i>=0;i--)
        {
             int maxAns=Integer.MIN_VALUE;
        int maxi=Integer.MIN_VALUE;
        int len=0;
        for(int j=i;j<Math.min(arr.length,i+k);j++)
        {
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=len*maxi+dp[j+1];
            maxAns=Math.max(maxAns,sum);
        }
         dp[i]=maxAns%1000000007;
        }
        return dp[0];
    }
    // memoization code
    // public int function(int i,int[] arr,int k,int[] dp)
    // {
    //     if(i==arr.length)
    //     {
    //         return 0;
    //     }
    //     if(dp[i]!=-1)
    //     {
    //         return dp[i];
    //     }
    //     int maxAns=Integer.MIN_VALUE;
    //     int maxi=Integer.MIN_VALUE;
    //     int len=0;
    //     for(int j=i;j<Math.min(arr.length,i+k);j++)
    //     {
    //         len++;
    //         maxi=Math.max(maxi,arr[j]);
    //         int sum=len*maxi+function(j+1,arr,k,dp);
    //         maxAns=Math.max(maxAns,sum);
    //     }
    //     return dp[i]=maxAns%1000000007;
    // }
}