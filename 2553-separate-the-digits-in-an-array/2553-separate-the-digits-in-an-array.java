class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> t=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            String st=String.valueOf(nums[i]);
            for(int j=0;j<st.length();j++)
            {
                t.add(st.charAt(j)-'0');
            }
        }
        int[] ans=new int[t.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=t.get(i);
        }
        return ans;
    }
}