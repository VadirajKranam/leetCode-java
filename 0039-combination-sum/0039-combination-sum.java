class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        function(0,candidates,target,ds,ans);
        return ans;
    }
    public void function(int i,int[] candidates,int target,List<Integer> ds,List<List<Integer>> ans)
    {
        if(i==candidates.length)
        {
            if(target==0)
            {
                List<Integer> t=new ArrayList<>(ds);
                ans.add(t);
                return;
            }
            return;
        }
        if(target-candidates[i]>=0)
        {
            ds.add(candidates[i]);
            function(i,candidates,target-candidates[i],ds,ans);
            ds.remove(ds.size()-1);
        }
        function(i+1,candidates,target,ds,ans);
    }
}