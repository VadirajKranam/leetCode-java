class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int s=nums[0];
        int b=nums[nums.length-1];
        return gcd(s,b);
    }
    int gcd(int a,int b)
    {
        if(a==0)
        {
            return b;
        }
        if(b==0)
        {
            return a;
        }
       if(a==b)
       {
           return a;
       }
        if(a>b)
        {
            return gcd(a-b,b);
        }
        return gcd(a,b-a);
    }
}