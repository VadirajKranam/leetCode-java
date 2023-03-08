class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
        {
            high=Math.max(high,piles[i]);
        }
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(canEat(piles,low,mid,h))
            {
                high=mid;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
    public boolean canEat(int[] piles,int l,int m,int h)
    {
        int hrs=0;
        for(int pile:piles)
        {
            int time=(int)Math.ceil((double)pile/(double)m);
            hrs+=time;
        }
        if(hrs<=h)
        {
            return true;
        }
        return false;
    }
}