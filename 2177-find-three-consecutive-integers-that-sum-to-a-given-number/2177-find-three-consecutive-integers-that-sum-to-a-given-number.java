class Solution {
    public long[] sumOfThree(long num) {
        if(num%3l!=0)
        {
            return new long[]{};
        }
        long mid=num/3l;
        return new long[]{mid-1,mid,mid+1};
    }
}