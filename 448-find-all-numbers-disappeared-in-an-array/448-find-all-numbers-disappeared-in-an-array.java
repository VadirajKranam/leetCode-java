class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer, Integer> h1=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            h1.put(nums[i],i);
        }
       
        for(int i=1;i<=nums.length;i++)
        {
          if(!h1.containsKey(i))
          {
              ans.add(i);
          }
        }
        return ans;
    }
}