class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        temp.add(0);
        dfs(0,graph,temp,ans);
        return ans;
    }
    public void dfs(int i,int[][] graph,List<Integer> temp,List<List<Integer>> ans)
    {
        if(i==graph.length-1)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j=0;j<graph[i].length;j++)
        {
            temp.add(graph[i][j]);
            dfs(graph[i][j],graph,temp,ans);
            temp.remove(temp.size()-1);
        }
        return;
    }
}