class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int currDiff=Integer.MAX_VALUE;
        int diff=Integer.MAX_VALUE;
        int ans=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int j=i+1,k=nums.length-1;
            int sum=target-nums[i];
            while(j<k)
            {
                if(nums[j]+nums[k]==sum)
                {
                    return nums[i]+nums[j]+nums[k];
                }
                else if(nums[j]+nums[k]<sum)
                {
                    
                    diff=Math.min(diff,Math.abs(sum-nums[j]-nums[k]));
                    if(currDiff!=diff)
                    {
                        currDiff=diff;
                        ans=nums[i]+nums[j]+nums[k];
                    }
                    j++;
                }
                else
                {
                    diff=Math.min(diff,Math.abs(sum-nums[j]-nums[k]));
                    if(currDiff!=diff)
                    {
                        currDiff=diff;
                        ans=nums[i]+nums[j]+nums[k];
                    }
                    k--;
                }
            }
        }
                                  return ans;
    }
}