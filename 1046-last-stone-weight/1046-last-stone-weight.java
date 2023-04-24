class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
        {
            pq.offer(stones[i]);
        }
       while(pq.size()>1)
       {
           int top1=pq.poll();
           int top2=pq.poll();
           if(top1!=top2)
           {
               pq.offer(top1-top2);
           }
       }
        if(pq.size()==0)
        {
            return 0;
        }
        return pq.poll();
    }
}