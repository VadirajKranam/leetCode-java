class Solution {
    public int[] findErrorNums(int[] nums) {
      int[] m=new int[nums.length+1];
        Arrays.fill(m,0);
        int[] ans=new int[2];
        for(int i=0;i<nums.length;i++)
        {
            m[nums[i]]++;
        }
        for(int i=1;i<m.length;i++)
        {
            if(m[i]==2)
            {
                ans[0]=i;
                break;
            }
        }
        for(int i=1;i<m.length;i++)
        {
            if(m[i]==0)
            {
                ans[1]=i;
                break;
            }
        }
        return ans;
    }
}