class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    int mod = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        long[] ways=new long[n];
        Arrays.fill(ways,0);
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.b-y.b);
        pq.offer(new Pair(0,0));
        while(!pq.isEmpty())
        {
            int node=pq.peek().a;
            int curDis=pq.peek().b;
            pq.poll();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjNode=adj.get(node).get(i).a;
                int wt=adj.get(node).get(i).b;
                if(curDis+wt<dist[adjNode])
                {
                    ways[adjNode]=ways[node];
                    dist[adjNode]=(curDis+wt);
                    pq.offer(new Pair(adjNode,curDis+wt));
                }
                else if(curDis+wt==dist[adjNode])
                {
                    ways[adjNode]=(ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1];
    }
}