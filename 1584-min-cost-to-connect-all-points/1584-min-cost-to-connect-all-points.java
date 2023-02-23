class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.a-y.a);
        int[] vis=new int[points.length];
        Arrays.fill(vis,0);
        pq.offer(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty())
        {
            int node=pq.peek().b;
            int wt=pq.peek().a;
            pq.poll();
            if(vis[node]==1)
            {
                continue;
            }
            vis[node]=1;
            sum+=wt;
            for(int i=0;i<points.length;i++)
            {
                if(i==node)
                {
                    continue;
                }
                int adjNode=i;
                int ew=(Math.abs(points[node][0]-points[i][0])+Math.abs(points[node][1]-points[i][1]));
        
                if(vis[adjNode]==0)
                {
                    pq.offer(new Pair(ew,adjNode));
                }
            }
        }
        return sum;
    }
}