class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        return function(total,cost1,cost2);
    }
    public long function(int total,int cost1,int cost2)
    {
        if(total<0)
        {
            return 0;
        }
      
        return 1+total/cost1+function(total-cost2,cost1,cost2);
    }
}