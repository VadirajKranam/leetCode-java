class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       ArrayList<Integer> a=new ArrayList<>();
        int i=0,j=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
            {
                a.add(nums1[i]);
                i++;
            }
            else 
            {
                a.add(nums2[j]);
                j++;
            }
        }
        while(i<nums1.length)
        {
            a.add(nums1[i]);
            i++;
        }
       while(j<nums2.length)
        {
            a.add(nums2[j]);
            j++;
        }
       if(a.size()%2==1)
       {
           return (double)a.get(a.size()/2);
       }
        return (double)(a.get(a.size()/2-1)+a.get(a.size()/2))/2;
     }
    
}