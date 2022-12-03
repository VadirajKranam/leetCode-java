class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            if(m.get(s.charAt(i))==null)
            {
                m.put(s.charAt(i),1);
            }
            else
            {
                m.put(s.charAt(i),m.get(s.charAt(i))+1);
            }
        }
        PriorityQueue<Character> pq=new PriorityQueue<>((a,b) -> m.get(b) - m.get(a));
        for(char ch:m.keySet())
        {
            pq.offer(ch);
        }
        String ans="";
        while(!pq.isEmpty())
        {
            char ch=pq.poll();
            for(int i=0;i<m.get(ch);i++)
            {
                ans+=ch;
            }
        }
        return ans;
    }
}