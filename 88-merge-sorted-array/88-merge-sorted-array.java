class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       Arrays.sort(nums1,0,m);
       Arrays.sort(nums2);
        int j=0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i]=nums2[j];
            j++;
        }
        Arrays.sort(nums1);
        return;
    }
}