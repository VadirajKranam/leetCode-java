class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        findCombinations(0,candidates,target,ans,ds);
        return ans;
    }
    public void findCombinations(int i,int[] candidates,int target,List<List<Integer>> ans,List<Integer> ds)
    {
        if(i==candidates.length)
        {
            if(target==0)
            {
                ans.add(new ArrayList<>(ds));
                return;
            }
            return;
        }
        if(candidates[i]<=target)
        {
            ds.add(candidates[i]);
            findCombinations(i,candidates,target-candidates[i],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(i+1,candidates,target,ans,ds);
    }
}