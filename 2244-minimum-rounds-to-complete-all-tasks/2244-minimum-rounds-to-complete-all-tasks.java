class Solution {
    public int minimumRounds(int[] tasks) {
        
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<tasks.length;i++)
        {
            if(m.containsKey(tasks[i]))
            {
                m.put(tasks[i],m.get(tasks[i])+1);
            }
            else
            {
                m.put(tasks[i],1);
            }
        }
        int count=0;
        for(Map.Entry<Integer,Integer> e:m.entrySet())
        {
            if(e.getValue()<2)
            {
                return -1;
            }
           int freq=e.getValue();
           if(freq==2)
           {
               count+=1;
               continue;
           }
           double res=freq/3.0;
            count+=Math.ceil(res);
    }
        return count;
    }
}