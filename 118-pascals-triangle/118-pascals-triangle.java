class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return ans;
        }
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> prevRow=ans.get(i-1);
            List<Integer> row=new ArrayList<>();
            row.add(1);
            for(int j=1;j<i;j++)
            {
                row.add(prevRow.get(j-1)+prevRow.get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}