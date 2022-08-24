class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        ArrayList<ArrayList<Integer>> merge=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<intervals.length;i++)
        {
            if(merge.isEmpty()||merge.get(merge.size()-1).get(1)<intervals[i][0])
            {
                ArrayList<Integer> t=new ArrayList<>();
                t.add(intervals[i][0]);
                t.add(intervals[i][1]);
                merge.add(t);
            }
            else
            {
                merge.get(merge.size()-1).set(1,(int)(Math.max(merge.get(merge.size()-1).get(1),intervals[i][1])));
            }
        }
        int[][] ans=new int[merge.size()][2];
        for(int i=0;i<merge.size();i++)
        {
            for(int j=0;j<merge.get(i).size();j++)
            {
                ans[i][j]=merge.get(i).get(j);
            }
        }
        return ans;
    }
}