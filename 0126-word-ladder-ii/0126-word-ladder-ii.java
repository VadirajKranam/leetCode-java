class Solution {
     List<List<String>> ans=new ArrayList<>();
    String b;
     Map<String,Integer> m=new HashMap<>();
    public List<List<String>> findLadders(String startWord, String targetWord, List<String> wordList) {
         Set<String> s=new HashSet<String>();
        for(String st:wordList)
        {
            s.add(st);
        }
        b=startWord;
       
        Queue<String> q=new LinkedList<>();
        q.offer(startWord);
        s.remove(startWord);
        m.put(startWord,1);
        int sz=startWord.length();
        while(!q.isEmpty())
        {
            String w=q.poll();
            int steps=m.get(w);
            if(w.equals(targetWord))
            {
                break;
            }
            for(int i=0;i<sz;i++)
            {
                
               
                for(char c='a';c<='z';c++)
                {
                    char[] charArray=w.toCharArray();
                    charArray[i]=c;
                    String temp=new String(charArray);
                    if(s.contains(temp))
                    {
                        q.offer(temp);
                        m.put(temp,steps+1);
                        s.remove(temp);
                    }
                }
            }
        }
        if(m.containsKey(targetWord))
        {
            List<String> sq=new ArrayList<>();
            sq.add(targetWord);
            dfs(targetWord,sq);
 
        }
        return ans;
    }
    private void dfs(String word,List<String> sq)
    {
        if(word.equals(b))
        {
           
            List<String> dup=new ArrayList<>(sq);
            Collections.reverse(dup);
            System.out.println(dup);
            ans.add(dup);
            return;
        }
        int sz=word.length();
        int steps=m.get(word);
         for(int i=0;i<sz;i++)
            {
                
               
                for(char c='a';c<='z';c++)
                {
                    char[] charArray=word.toCharArray();
                    charArray[i]=c;
                    String temp=new String(charArray);
                    if(m.containsKey(temp) && m.get(temp)+1==steps)
                    {
                        sq.add(temp);
                        dfs(temp,sq);
                        sq.remove(sq.size()-1);
                    }
                }
                
            }
    }
}