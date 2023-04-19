class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> t=new ArrayList<>();
        function(0,candidates,ans,t,target);
        return ans;
    }
    public void function(int i,int[] candidates,List<List<Integer>> ans,List<Integer> t,int target)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(t));
        }
        for(int ind=i;i<candidates.length;i++)
        {
            if(i>ind && candidates[i]==candidates[i-1])
            {
                continue;
            }
            if(candidates[i]>target)
            {
                break;
            }
            t.add(candidates[i]);
            function(i+1,candidates,ans,t,target-candidates[i]);
            t.remove(t.size()-1);
            //function(i+1,candidates,ans,t,target);
        }
    }
}