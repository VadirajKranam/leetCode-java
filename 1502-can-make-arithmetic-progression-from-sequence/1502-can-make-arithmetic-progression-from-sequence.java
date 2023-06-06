class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        if(arr.length==1)
        {
            return true;
        }
        int d=arr[1]-arr[0];
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]-arr[i-1]!=d)
            {
                return false;
            }
        }
        return true;
    }
}