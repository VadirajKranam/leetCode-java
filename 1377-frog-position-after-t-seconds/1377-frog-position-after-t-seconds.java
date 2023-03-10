class Pair{
    int a,t;
    double b;
    Pair(int a,double b,int t)
    {
        this.a=a;
        this.b=b;
        this.t=t;
    }
}
class Solution {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        double ans=0.0;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis=new int[n+1];
        Arrays.fill(vis,-1);
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(1,1.0,t));
        while(!q.isEmpty())
        {
            Pair node=q.poll();
            vis[node.a]=1;
            
            if(node.a==target && node.t>0)
            {
                boolean checkVisited=true;
                for(int i=0;i<adj.get(node.a).size();i++)
                {
                    if(vis[adj.get(node.a).get(i)]==-1)
                    {
                        //System.out.println(vis[adj.get(node.a).get(i)]);
                        checkVisited=false;
                        break;
                    }
                }
                //System.out.println(Arrays.toString(vis));
                if(checkVisited)
                {
                    return node.b;
                }
                else
                {
                    return 0.0;
                }
            }
            else if(node.a==target && node.t==0)
            {
                return node.b;
            }
            else if(node.a==target)
            {
                return 0.0;
            }
             //System.out.println(node.b);
            double curPro=node.b;
            int count=0;
            for(int i=0;i<adj.get(node.a).size();i++)
            {
                if(vis[adj.get(node.a).get(i)]==-1)
                {
                    count++;
                }
            }
            for(int i=0;i<adj.get(node.a).size();i++)
            {
                if(vis[adj.get(node.a).get(i)]!=-1)
                {
                    continue;
                }
                q.offer(new Pair(adj.get(node.a).get(i),curPro*((double)1.0/(double)count),node.t-1));
                //System.out.println(curPro*((double)1.0/(double)count));
            }
            
        }
        return 0.0;
    }
}