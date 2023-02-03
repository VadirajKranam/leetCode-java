class Solution {
    public List<Integer> getRow(int numRows) {
      List<List<Integer>> ans=new ArrayList<>();
        List<Integer> f=new ArrayList<>();
        f.add(1);
        ans.add(f);
        for(int i=1;i<=numRows;i++)
        {
            List<Integer> inner=new ArrayList<>();
            inner.add(1);
            for(int j=1;j<i;j++)
            {
                int num=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                inner.add(num);
            }
            inner.add(1);
            ans.add(inner);
        }
        return ans.get(ans.size()-1);  
    }
}