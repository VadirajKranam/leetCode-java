class Solution {
    public int minCost(int n, int[] cuts) {
        int[] newCut=new int[cuts.length+2];
        newCut[0]=0;
        newCut[cuts.length+1]=n;
        for(int i=1;i<=cuts.length;i++)
        {
            newCut[i]=cuts[i-1];
        }
        Arrays.sort(newCut);
      int[][] dp=new int[newCut.length+1][newCut.length+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        // System.out.println(Arrays.toString(newCut));
        return function(1,cuts.length,newCut,dp);
    }
    public int function(int i,int j,int[] cuts,int[][] dp)
    {
        if(i>j)
        {
            return 0;
        }
        int min=Integer.MAX_VALUE;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        for(int ind=i;ind<=j;ind++)
        {
            int cost=cuts[j+1]-cuts[i-1]+function(i,ind-1,cuts,dp)+function(ind+1,j,cuts,dp);
            min=Math.min(min,cost);
        }
       return dp[i][j]=min;
    }
}