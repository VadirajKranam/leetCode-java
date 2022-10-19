class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<triangle.size();i++)
        {
            ArrayList<Integer> l=new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++)
            {
                l.add(-1);
            }
            dp.add(l);
        }
        return function(0,0,triangle,dp);
    }
    public int function(int m,int n,List<List<Integer>> triangle,ArrayList<ArrayList<Integer>> dp)
    {
        if(m>=triangle.size() || n>=triangle.get(m).size())
        {
            return 0;
        }
        if(m==triangle.size()-1)
        {
            return triangle.get(m).get(n);
        }
        if(dp.get(m).get(n)!=-1)
        {
            return dp.get(m).get(n);
        }
        int up=triangle.get(m).get(n)+function(m+1,n+1,triangle,dp);
        int down=triangle.get(m).get(n)+function(m+1,n,triangle,dp);
        dp.get(m).set(n,Math.min(up,down));
        return dp.get(m).get(n);
    }
}