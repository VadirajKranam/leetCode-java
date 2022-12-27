class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] rem=new int[rocks.length];
        for(int i=0;i<rocks.length;i++)
        {
            rem[i]=capacity[i]-rocks[i];
        }
        Arrays.sort(rem);
        int rs=0;
        
        for(int i=0;i<rem.length;i++)
        {
            rs=rs+rem[i];
            if(rs==additionalRocks)
            {
                return i+1;
            }
            if(rs>additionalRocks)
            {
                return i;
            }
        }
        return rem.length;
        
    }
}