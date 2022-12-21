class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] d:dislikes)
        {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        int[] colors=new int[n+1];
        Arrays.fill(colors,0);
        for(int i=0;i<=n;i++)
        {
            if(colors[i]==0)
            {
                Queue<Integer> q=new LinkedList<>();
                q.offer(i);
                colors[i]=1;
                while(!q.isEmpty())
                {
                    int node=q.poll();
                    for(int j=0;j<adj.get(node).size();j++)
                    {
                        if(colors[adj.get(node).get(j)]==0)
                        {
                            colors[adj.get(node).get(j)]=-colors[node];
                            q.offer(adj.get(node).get(j));
                        }
                        else if(colors[adj.get(node).get(j)]==colors[node])
                        {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}