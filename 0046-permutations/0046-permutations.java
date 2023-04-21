class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        
        function(0,nums,ans);
        return ans;
    }
    public void function(int ind,int[] nums,List<List<Integer>> ans)
    {
        if(ind==nums.length)
        {
            List<Integer> in=new ArrayList<>();
           for(int i=0;i<nums.length;i++)
           {
               in.add(nums[i]);
           }
            ans.add(new ArrayList<>(in));
            return;
        }
        for(int i=ind;i<nums.length;i++)
        {
            swap(i,ind,nums);
            function(ind+1,nums,ans);
            swap(i,ind,nums);
        }
    }
    public void swap(int i1,int i2,int[] nums)
    {
        int t=nums[i1];
        nums[i1]=nums[i2];
        nums[i2]=t;
    }
}