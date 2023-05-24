class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pair=new int[nums1.length][2];
        for(int i=0;i<nums1.length;i++)
        {
            pair[i]=new int[]{nums2[i],nums1[i]};
        }
        Arrays.sort(pair,(a,b)->{return b[0]-a[0];});
        PriorityQueue<Integer> p=new PriorityQueue<>(k,(a,b)->{return a-b;});
        long sum=0;
        long ans=0;
        for(int i=0;i<pair.length;i++)
        {
            p.offer(pair[i][1]);
            sum+=pair[i][1];
            if(p.size()>k)
            {
                sum-=p.poll();
            }
            if(p.size()==k)
            {
                ans=Math.max(ans,sum*pair[i][0]);
            }
        }
        return ans;
    }
}