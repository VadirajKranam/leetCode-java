class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<times.length;j++)
            {
                int currD=dist[times[j][0]];
                int adjNode=dist[times[j][1]];
                int wt=times[j][2];
                if(currD!=Integer.MAX_VALUE && currD+wt<adjNode)
                {
                    dist[times[j][1]]=currD+wt;
                }
            }
        }
        System.out.println(Arrays.toString(dist));
        for(int i=1;i<dist.length;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=1;i<dist.length;i++)
        {
            if(dist[i]>max)
            {
                max=dist[i];
            }
        }
        return max;
    }
}
 