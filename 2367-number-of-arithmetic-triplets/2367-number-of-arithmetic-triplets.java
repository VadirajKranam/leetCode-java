class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
       int count=0;
        for(int i=0;i<nums.length-2;i++)
        {
           boolean check=false;
            int j=i+1;
            while(j<nums.length-1)
            {
                if(nums[j]-nums[i]==diff)
                {
                    check=true;
                    break;
                }
                j++;
            }
            if(check)
            {
                int k=j+1;
                while(k<nums.length)
                {
                    if(nums[k]-nums[j]==diff)
                    {
                        count++;
                        break;
                    }
                    k++;
                }
            }
            
        }
        return count;
    }
}