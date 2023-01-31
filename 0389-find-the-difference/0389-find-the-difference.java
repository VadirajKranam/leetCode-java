class Solution {
    public char findTheDifference(String s, String t) {
        ArrayList<Character> s1=new ArrayList<>();
        ArrayList<Character> s2=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            s1.add(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++)
        {
            s2.add(t.charAt(i));
        }
        Collections.sort(s1);
        Collections.sort(s2);
        for(int i=0;i<Math.min(s1.size(),s2.size());i++)
        {
            if(s1.get(i)!=s2.get(i))
            {
                return s2.get(i);
            }
        }
        return s2.get(s2.size()-1);
    }
}