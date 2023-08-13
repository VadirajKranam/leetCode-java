class Pair{
    String s;
    int steps;
    Pair(String s,int steps)
    {
        this.s=s;
        this.steps=steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      Set<String> s=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<wordList.size();i++)
        {
            s.add(wordList.get(i));
        }
        q.offer(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            
            if(q.peek().s.equals(endWord))
            {
                return q.peek().steps;
            }
            String st=q.peek().s;
            int steps=q.peek().steps;
            q.poll();
            for(int i=0;i<st.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] wa=st.toCharArray();
                    wa[i]=ch;
                    String nst=new String(wa);
                    if(s.contains(nst))
                    {
                        q.offer(new Pair(nst,steps+1));
                        s.remove(nst);
                    }
                }
            }
            
        }
        return 0;
    }
}