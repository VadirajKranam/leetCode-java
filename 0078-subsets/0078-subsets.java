class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        function(0,nums,ans,t);
        return ans;
    }
    public void function(int i,int[] nums,List<List<Integer>> ans,List<Integer> t)
    {
        if(i>=nums.length)
        {
            List<Integer> k=new ArrayList<>(t);
            ans.add(k);
            return;
        }
        t.add(nums[i]);
        function(i+1,nums,ans,t);
        t.remove(t.size()-1);
        function(i+1,nums,ans,t);
    }
}