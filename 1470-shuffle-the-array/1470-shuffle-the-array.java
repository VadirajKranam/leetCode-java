class Solution {
    public int[] shuffle(int[] nums, int n) {
      int[] num1=new int[n];
        int[] num2=new int[n];
        for(int i=0;i<n;i++)
        {
            num1[i]=nums[i];
        }
        for(int i=n;i<2*n;i++)
        {
            num2[i-n]=nums[i];
        }
        int[] ans=new int[nums.length];
        int k=0;
        int j=0;
        for(int i=0;i<2*n;i++)
        {
            if(i%2==0)
            {
                ans[i]=num1[j];
                j++;
            }
            else
            {
                ans[i]=num2[k];
                k++;
            }
        }
        return ans;
    }
}