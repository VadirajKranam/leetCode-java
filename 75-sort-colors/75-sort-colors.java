class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                zero++;
            }
            else if(nums[i]==1)
            {
                one++;
            }
            else
            {
                two++;
            }
        }
        int k=0;
        while(zero!=0)
        {
            nums[k]=0;
            k++;
            zero--;
        }
        while(one!=0)
        {
            nums[k]=1;
            k++;
            one--;
        }
        while(k<nums.length)
        {
            nums[k]=2;
            k++;
        }
    }
}