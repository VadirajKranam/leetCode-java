class Solution {
    public int[] countBits(int n) {
        int[] ans=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            int k=i;
            int count=0;
            while(i!=0)
            {
                if(i%2==1)
                {
                    count++;
                }
                i/=2;
            }
            i=k;
            ans[i]=count;
        }
        return ans;
    }
}