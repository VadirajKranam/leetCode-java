class Solution {
    public boolean isAnagram(String s, String t) {
        int[] m1=new int[26];
        int[] m2=new int[26];
        Arrays.fill(m1,0);
        Arrays.fill(m2,0);
        if(s.length()!=t.length())
        {
            return false;
        }
        for(int i=0;i<s.length();i++)
        {
            m1[s.charAt(i)-'a']++;
            m2[t.charAt(i)-'a']++;
        }
        for(int i=0;i<m1.length;i++)
        {
            if(m1[i]!=m2[i])
            {
                return false;
            }
        }
        return true;
    }
}