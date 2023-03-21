class Solution {
    public String largestNumber(int[] nums) {
        String[] arr=new String[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            arr[i]=Integer.toString(nums[i]);
        }
        Arrays.sort(arr,(a,b) -> (b+a).compareTo(a+b));
        if(arr[0].charAt(0)=='0')
        {
            return "0";
        }
        String t="";
        for(int i=0;i<arr.length;i++)
        {
            t+=arr[i];
        }
        return t;
    }
}