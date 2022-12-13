class Solution {
    public boolean canFinish(int numCourses, int[][] p) {
        ArrayList<Integer>[] adj=new ArrayList[numCourses];
        for(int i=0;i<adj.length;i++)
        {
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<p.length;i++)
        {
            adj[p[i][0]].add(p[i][1]);
        }
        int[] indegree=new int[numCourses];
        Arrays.fill(indegree,0);
        for(int i=0;i<adj.length;i++)
        {
            for(int j=0;j<adj[i].size();j++)
            {
                indegree[adj[i].get(j)]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty())
        {
            int node=q.poll();
            count++;
            for(int i=0;i<adj[node].size();i++)
            {
                indegree[adj[node].get(i)]--;
                if(indegree[adj[node].get(i)]==0)
                {
                    q.offer(adj[node].get(i));
                }
            }
        }
        if(count==numCourses)
        {
            return true;
        }
        return false;
    }
}