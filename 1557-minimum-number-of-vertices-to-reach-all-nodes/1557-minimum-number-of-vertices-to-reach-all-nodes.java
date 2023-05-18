class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++)
        {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        int[] incoming=new int[n];
        Arrays.fill(incoming,-1);
        for(int i=0;i<adj.size();i++)
        {
            for(int j=0;j<adj.get(i).size();j++)
            {
                incoming[adj.get(i).get(j)]=1;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<incoming.length;i++)
        {
            if(incoming[i]==-1)
            {
                ans.add(i);
            }
        }
        return ans;
    }
}