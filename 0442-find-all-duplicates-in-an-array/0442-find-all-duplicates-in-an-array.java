class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        int[] f=new int[nums.length+1];
        for(int i=0;i<nums.length;i++)
        {
            f[nums[i]]++;
        }
        for(int i=0;i<f.length;i++)
        {
            if(f[i]==2)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}