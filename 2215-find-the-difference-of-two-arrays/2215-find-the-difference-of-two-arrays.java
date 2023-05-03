class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> t1=new HashSet<>();
        Set<Integer> t2=new HashSet<>();
        for(int n:nums1)
        {
            t1.add(n);
        }
        for(int n:nums2)
        {
            t2.add(n);
        }
        Set<Integer> s1=new HashSet<>();
        for(int n:nums1)
        {
            if(!t2.contains(n))
            {
                s1.add(n);
            }
        }
        Set<Integer> s2=new HashSet<>();
        for(int n:nums2)
        {
            if(!t1.contains(n))
            {
                s2.add(n);
            }
        }
        
        List<Integer> a1=new ArrayList<>(s1);
        List<Integer> a2=new ArrayList<>(s2);
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(a1);
        ans.add(a2);
        return ans;
    }
}