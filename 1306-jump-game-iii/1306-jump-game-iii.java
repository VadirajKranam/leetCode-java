class Solution {
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0)
        {
            return true;
        }
        if(arr[start]<0)
        {
            return false;
        }
        arr[start]=-arr[start];
        int x=start-arr[start];
        if(x<arr.length && canReach(arr,x))
        {
            return true;
        }
        x=start+arr[start];
        if(x>=0 && canReach(arr,x))
        {
            return true;
        }
        return false;
    }
}