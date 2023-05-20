class Solution {
    public int missingNumber(int[] nums) {
        int[] vis=new int[nums.length+1];
        Arrays.fill(vis,-1);
        for(int i=0;i<nums.length;i++)
        {
            vis[nums[i]]=1;
        }
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==-1)
            {
                return i;
            }
        }
        return vis.length;
    }
}