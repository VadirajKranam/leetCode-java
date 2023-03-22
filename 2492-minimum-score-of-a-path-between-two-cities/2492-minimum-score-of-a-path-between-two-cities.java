class Pair{
    int a,b;
    Pair(int a,int b)
    {
        this.a=a;
        this.b=b;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        Queue<Pair> q=new LinkedList<>();
        int min=Integer.MAX_VALUE;
        int ans=Integer.MAX_VALUE;
        q.offer(new Pair(1,Integer.MAX_VALUE));
        int[] vis=new int[n+1];
        Arrays.fill(vis,-1);
        while(!q.isEmpty())
        {
            int node=q.peek().a;
            int dis=q.peek().b;
            q.poll();
            // if(node==n)
            // {
            //     ans=Math.min(ans,min);
            //     System.out.println(ans);
            //     continue;
            // }
            vis[node]=1;
            min=Math.min(min,dis);
            for(int i=0;i<adj.get(node).size();i++)
            {
               
                if(vis[adj.get(node).get(i).a]==-1){
                     
                q.offer(new Pair(adj.get(node).get(i).a,adj.get(node).get(i).b));
                }
            }
        }
        return min;
    }
}