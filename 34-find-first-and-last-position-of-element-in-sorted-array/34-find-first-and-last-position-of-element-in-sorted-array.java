class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        if(nums.length==0)
        {
            return new int[] {-1,-1};
        }
        int index=0;
        while(s<=e)
        {
            int mid=s+(e-s)/2;
            if(nums[mid]==target)
            {
                index=mid;
                break;
            }
            else if(nums[mid]>target)
            {
                e=mid-1;
            }
            else
            {
                s=mid+1;
            }
        }
        int start=-1;
        int end=-1;
        int check=index;
        while(check>=0 && nums[check]==target)
        {
            start=check;
            check--;
        }
        check=index;
        while(check<nums.length && nums[check]==target)
        {
            end=check;
            check++;
        }
        return new int[] {start,end};
    }
}