class Solution {
    public int getWinner(int[] arr, int k) {
        Deque<Integer> d=new ArrayDeque<>();
        Map<Integer,Integer> m=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            d.addLast(arr[i]);
            max=Math.max(max,arr[i]);
        }
        if(k>=arr.length)
        {
            return max;
        }
        while(true)
        {
            int first=d.removeFirst();
            int second=d.removeFirst();
            if(first>second)
            {
                d.addFirst(first);
                d.addLast(second);
                if(m.getOrDefault(first,0)+1==k)
                {
                    return first;
                }
                m.put(first,m.getOrDefault(first,0)+1);
            }
            else
            {
                d.addFirst(second);
                d.addLast(first);
                if(m.getOrDefault(second,0)+1==k)
                {
                    return second;
                }
                m.put(second,m.getOrDefault(second,0)+1);
            }
        }
     
    }
}