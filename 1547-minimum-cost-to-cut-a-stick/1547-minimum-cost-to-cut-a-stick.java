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
      int[][] dp=new int[newCut.length+2][newCut.length+2];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],0);
        }
       for(int i=cuts.length;i>=1;i--)
       {
           for(int j=0;j<=cuts.length;j++)
           {
               if(i>j)
               {
                   continue;
               }
               int min=Integer.MAX_VALUE;
               for(int k=i;k<=j;k++)
               {
                   int cost=newCut[j+1]-newCut[i-1]+dp[i][k-1]+dp[k+1][j];
                   min=Math.min(min,cost);
               }
               dp[i][j]=min;
           }
       }
        return dp[1][cuts.length];
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