class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> m=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            m.put(s.charAt(i),m.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(m.get(s.charAt(i))==1)
            {
                return i;
            }
        }
        return -1;
    }
}