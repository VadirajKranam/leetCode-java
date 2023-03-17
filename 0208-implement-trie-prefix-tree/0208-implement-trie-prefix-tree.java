class Trie {
    Map<String,Integer> m=new HashMap<>();
    Map<String,Integer> n=new HashMap<>();
    public Trie() {
        
    }
    
    public void insert(String word) {
        if(m.get(word)==null)
        {
            m.put(word,1);
            String a="";
            for(int i=0;i<word.length();i++)
            {
                a+=word.charAt(i);
                n.put(a,1);
            }
            return;
        }
        return;
    }
    
    public boolean search(String word) {
        if(m.containsKey(word))
        {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
         if(n.containsKey(prefix))
        {
            return true;
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */