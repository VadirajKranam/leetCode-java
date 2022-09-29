class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<List<Integer>> t1=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            List<Integer> t2=new ArrayList<>();
            t2.add(arr[i]);
            t2.add(Math.abs(arr[i]-x));
            t1.add(t2);
        }
        Collections.sort(t1,new Comparator<List<Integer>>(){
           @Override
            public int compare(List<Integer> a1,List<Integer> a2)
            {
                return Double.compare(a1.get(1),a2.get(1));
            }
        });
       List<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<k)
        {
            ans.add(t1.get(i).get(0));
            i++;
        }
        Collections.sort(ans);
        return ans;
    }
}