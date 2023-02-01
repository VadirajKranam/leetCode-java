class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    nums2[j]=-1;
                    a.add(nums1[i]);
                    break;
                }
            }
        }
        int[] ans=new int[a.size()];
        for(int i=0;i<a.size();i++)
        {
            ans[i]=a.get(i);
        }
        return ans;
    }
}