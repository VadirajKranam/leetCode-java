class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> m=new HashMap<>();
        int k=0;
       
        for(int i=0;i<pattern.length();i++)
        {
            String temp="";
            while(k<s.length() && s.charAt(k)!=' ')
            {
                temp+=s.charAt(k);
                k++;
               
            }
             
            k++;
            if(m.get(pattern.charAt(i))!=null && !m.get(pattern.charAt(i)).equals(temp))
            {
                return false;
            }
            else
            {
                m.put(pattern.charAt(i),temp);
            }
        }
         int words=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==' ')
            {
                words++;
            }
        }
        words++;
        if(words!=pattern.length())
        {
            return false;
        }
        for(Map.Entry<Character,String> e:m.entrySet())
        {
            for(Map.Entry<Character,String> l:m.entrySet())
            {
                if(l.getKey()!=e.getKey() && l.getValue().equals(e.getValue()))
                {
                    return false;
                }
                
            }
        }
        
        return true;
      
    }
}