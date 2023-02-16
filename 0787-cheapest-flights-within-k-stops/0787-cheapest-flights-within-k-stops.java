class pair{
    int a,b;
    pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class trio{
    int a,b,c;
    trio(int a,int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<trio> q=new LinkedList<>();
        q.offer(new trio(0,src,0));
        dist[src]=0;
        while(!q.isEmpty())
        {
            trio cn=q.poll();
            int stops=cn.a;
            int node=cn.b;
            int dis=cn.c;
            for(int i=0;i<adj.get(node).size();i++)
            {
                int adjNode=adj.get(node).get(i).a;
                int ew=adj.get(node).get(i).b;
                if(dis+ew<dist[adjNode] && stops<=k)
                {
                    dist[adjNode]=dis+ew;
                    q.offer(new trio(stops+1,adjNode,dist[adjNode]));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
        {
            return -1;
        }
        return dist[dst];
    }
}