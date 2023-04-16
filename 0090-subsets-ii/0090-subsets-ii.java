class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        Arrays.sort(nums);
        function(0,nums,in,ans);
        return ans;
    }
    public void function(int ind,int[] nums,List<Integer> in,List<List<Integer>> ans)
    {
        
            ans.add(new ArrayList<>(in));
            
        for(int i=ind;i<nums.length;i++)
        {
            if(i!=ind && nums[i]==nums[i-1])
            {
                continue;
            }
            in.add(nums[i]);
            function(i+1,nums,in,ans);
            in.remove(in.size()-1);
        }
    }
}