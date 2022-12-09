class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> s=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum=sum%1000000007+nums[j]%1000000007;
                s.add(sum%100000007);
            }
        }
        Collections.sort(s);
        int ans=0;
        for(int i=left-1;i<right;i++)
        {
            ans=ans%1000000007+s.get(i)%1000000007;
        }
        return ans%1000000007;
    }
}