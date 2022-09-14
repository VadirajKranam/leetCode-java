class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<ArrayList<Integer>> merged=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->{return a[0]-b[0];});
        for(int i=0;i<intervals.length;i++)
        {
            for(int j=0;j<intervals[i].length;j++)
            {
                if(merged.isEmpty()||merged.get(merged.size()-1).get(1)<intervals[i][0])
                {
                    ArrayList<Integer> t=new ArrayList<>();
                    t.add(intervals[i][0]);
                    t.add(intervals[i][1]);
                    merged.add(t);
                }
                else
                {
                   merged.get(merged.size()-1).set(1,(int)Math.max(merged.get(merged.size()-1).get(1),intervals[i][1])); 
                }
            }
        }
        int[][] ans=new int[merged.size()][2];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                ans[i][j]=merged.get(i).get(j);
            }
        }
        return ans;
    }
}