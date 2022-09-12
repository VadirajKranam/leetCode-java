class Solution {
    public double myPow(double x, int n) {
        double ans=1.0;
        long nn=n;
        if(nn<1)
        {
            nn*=-1;
        }
        while(nn>0)
        {
            if(nn%2==1)
            {
                ans=ans*x;
                nn=nn-1;
            }
            else
            {
                x=x*x;
                nn/=2;
            }
        }
        if(n<0)
        {
            return (double)(1.0)/ans;
        }
        return ans;
    }
}