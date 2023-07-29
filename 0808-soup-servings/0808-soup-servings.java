class Solution {
    public double soupServings(int n) {
        if(n>=4800)
        {
            return 1;
        }
       double[][] dp=new double[n+1][n+1];
        for(double[] d:dp)
        {
            Arrays.fill(d,-1.0);
        }
      return function(n,n,dp);  
    }
    public double function(int a,int b,double[][] dp)
    {
        if(a<=0 && b<=0)
           {
               return 0.5;
           }
          else if(a<=0)
           {
               return 1;
           }
           
           else if(b<=0)
           {
               return 0;
           }
     if(dp[a][b]!=-1.0)
     {
         return dp[a][b];
     }
        double first=function(a-100,b,dp);
        double second=function(a-75,b-25,dp);
        double third=function(a-50,b-50,dp);
        double fourth=function(a-25,b-75,dp);
        return dp[a][b]=(first+second+third+fourth)*0.25;
    }
}