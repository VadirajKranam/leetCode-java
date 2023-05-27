class Solution {
    public int[] searchRange(int[] arr, int x) {
        int first=-1;
        int last=-1;
        int low=0,high=arr.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(arr[mid]==x)
            {
                first=mid;
                last=mid;
                break;
            }
            else if(arr[mid]<x)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        if(first==-1)
        {
         int[] ans=new int[2];
        ans[0]=first;
        ans[1]=last;
        return ans;
        }
        while(first>=0 && arr[first]==x)
        {
            first--;
        }
        while(last<arr.length && arr[last]==x)
        {
            last++;
        }
        first+=1;
        last-=1;
        int[] ans=new int[2];
        ans[0]=first;
        ans[1]=last;
        return ans;
    }
}