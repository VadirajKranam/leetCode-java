class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length==1)
        {
            return true;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        int p1=function(0,nums.length-1,nums);
        int p2=sum-p1;
        return p1>=p2;
    }
    public int function(int i,int j,int[] nums)
    {
        if(i>j)
        {
            return 0;
        }
        int op1=nums[i]+Math.min(function(i+2,j,nums),function(i+1,j-1,nums));
        int op2=nums[j]+Math.min(function(i+1,j-1,nums),function(i,j-2,nums));
        return Math.max(op1,op2);
    }
}