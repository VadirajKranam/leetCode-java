class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character,Integer> m=new HashMap<>();
        int c=0;
        for(int i=0;i<order.length();i++)
        {
            m.put(order.charAt(i),c);
            c++;
        }
        for(int i=0;i<words.length-1;i++)
        {
            
                int k1=0,k2=0,j=i+1;
                while((k1<words[i].length() && k2<words[j].length()) &&(words[i].charAt(k1)==words[j].charAt(k2)))
                {
                    k1++;
                    k2++;
                }
                if(k2>=words[j].length() && k1<words[i].length())
                {
                    return false;
                }
                if(k1>=words[i].length() && k2<words[j].length())
                {
                    continue;
                }
               if(k1==k2 && k1==words[i].length() && k2==words[j].length())
               {
                   continue;
               }
               if(m.get(words[i].charAt(k1))>m.get(words[j].charAt(k2)))
               {
                   return false;
               }
            }
        
        return true;
    }
}