class Solution {
    public int arraySign(int[] nums) {
       int count=0;
        for(int n:nums)
        {
            if(n==0)
            {
                return 0;
            }
            if(n<0)
            {
                count+=1;
                count%=2;
            }
        }
        if(count==1)
        {
            return -1;
        }
        return 1;
    }
}