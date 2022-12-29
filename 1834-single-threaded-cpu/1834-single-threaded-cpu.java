class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] extTask=new int[n][3];
        for(int i=0;i<tasks.length;i++)
        {
            extTask[i][0]=i;
            extTask[i][1]=tasks[i][0];
            extTask[i][2]=tasks[i][1];
        }
        Arrays.sort(extTask,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>((a,b)->a[2]==b[2]?a[0]-b[0]:a[2]-b[2]);
        int time=0;
        int ai=0;
        int ti=0;
        int[] ans=new int[n];
        while(ai<n)
        {
            while(ti<n && extTask[ti][1]<=time)
            {
                pq.offer(extTask[ti]);
                ti++;
            }
            if(pq.isEmpty())
            {
                time=extTask[ti][1];
                continue;
            }
            int[] bestFit=pq.poll();
            ans[ai]=bestFit[0];
            ai++;
            time+=bestFit[2];
        }
        return ans;
    }
}