class Solution {
    int longestValue=1;
    public int longestPath(int[] parent, String s) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=1;i<parent.length;i++)
        {
            int j=parent[i];
            adj.putIfAbsent(j,new ArrayList<>());
            adj.get(j).add(i);
        }
        dfs(0,adj,s);
        return longestValue;
    }
    public int dfs(int ind,Map<Integer,List<Integer>> adj,String s)
    {
        if(!adj.containsKey(ind))
        {
            return 1;
        }
        int max=0,secondMax=0;
        for(int nbrNode:adj.get(ind))
        {
            int longestPathFromNbrNode=dfs(nbrNode,adj,s);
            if(s.charAt(ind)==s.charAt(nbrNode))
            {
                continue;
            }
            if(longestPathFromNbrNode>max)
            {
                secondMax=max;
                max=longestPathFromNbrNode;
            }
            else if(longestPathFromNbrNode>secondMax)
            {
                secondMax=longestPathFromNbrNode;
            }
        }
        longestValue=Math.max(longestValue,max+secondMax+1);
        return max+1;
    }
}