class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp=new int[m][];
        for(int i=0;i<triangle.size();i++)
        {
            dp[i]=new int[triangle.get(i).size()];
            Arrays.fill(dp[i],-9999999);
        }
        for(int i=0;i<dp[dp.length-1].length;i++)
        {
            dp[m-1][i]=triangle.get(m-1).get(i);
        }
        
        for(int i=m-2;i>=0;i--)
        {
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int up=triangle.get(i).get(j)+dp[i+1][j];
                int down=9999999;
                    down=triangle.get(i).get(j)+dp[i+1][j+1];
                   dp[i][j]=Math.min(up,down);
            }
        }
       
        return dp[0][0];
    }
}