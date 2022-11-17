class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int count=0;
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<allowed.length();i++)
        {
            m.put(allowed.charAt(i),i);
        }
        for(int i=0;i<words.length;i++)
        {
            boolean check=true;
            for(int j=0;j<words[i].length();j++)
            {
                if(!m.containsKey(words[i].charAt(j)))
                {
                    check=false;
                    break;
                }
            }
            if(check)
            {
                count++;
            }
        }
        return count;
    }
}