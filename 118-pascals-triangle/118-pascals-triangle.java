class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> tr=new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return tr;
        }
        List<Integer> f=new ArrayList<Integer>();
        f.add(1);
        tr.add(f);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> inner=new ArrayList<Integer>();
            inner.add(1);
            for(int j=0;j<i-1;j++)
            {
                inner.add(tr.get(i-1).get(j)+tr.get(i-1).get(j+1));
            }
            inner.add(1);
            tr.add(inner);
        }
        return tr;
    }
}