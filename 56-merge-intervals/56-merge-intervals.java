class Solution {
    public int[][] merge(int[][] intervals) {
        for(int i=0;i<intervals.length;i++)
        {
            if(intervals[i][0]>intervals[i][1])
            {
                int t=intervals[i][0];
                intervals[i][0]=intervals[i][1];
                intervals[i][1]=t;
            }
        }
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] i1,int[] i2)
            {
                return Double.compare(i1[0],i2[0]);
            }
        });
     ArrayList<ArrayList<Integer>> merge=new ArrayList<>();
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
          ArrayList<Integer> t=new ArrayList<>();
          int t1=merge.get(merge.size()-1).get(0);
 int t2=(int)(Math.max(merge.get(merge.size()-1).get(1),intervals[i][1]));
          t.add(t1);
          t.add(t2);
          merge.set(merge.size()-1,t);
      }
        }
        int[][] ans=new int[merge.size()][merge.get(0).size()];
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[0].length;j++)
            {
                ans[i][j]=merge.get(i).get(j);
            }
        }
        return ans;
    }
}