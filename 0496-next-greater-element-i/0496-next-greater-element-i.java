class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
      int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            int j=0;
            for(j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    break;
                }
            }
            int max=-1;
            j++;
            while(j<nums2.length)
            {
                if(nums2[j]>nums1[i])
                {
                    max=nums2[j];
                    break;
                }
                j++;
            }
            ans[i]=max;
        }
        return ans;
    }
}