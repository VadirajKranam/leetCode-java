class Solution {
    public int lengthOfLIS(int[] nums) {
      ArrayList<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>ans.get(ans.size()-1))
            {
                ans.add(nums[i]);
            }
            else
            {
                int ind=Collections.binarySearch(ans,nums[i]);
                if(ind<0)
                {
                    int realInd=(ind+1)*-1;
                    if(realInd>ans.size()-1)
                    {
                        ans.add(nums[i]);
                    }
                    else
                    {
                        ans.set(realInd,nums[i]);
                    }
                }
                else
                {
                    ans.set(ind,nums[i]);
                }
            }
        }
        return ans.size();
    }
}