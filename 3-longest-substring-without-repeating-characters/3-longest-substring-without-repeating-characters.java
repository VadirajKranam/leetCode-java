class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()<=1)
        {
            return s.length();
        }
        String check=s.trim();
        if(check.length()==0)
        {
            return 1;
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++)
        {
            Set<Character> se=new HashSet<>();
            for(int j=i;j<s.length();j++)
            {
                if(se.contains(s.charAt(j)))
                {
                    max=Math.max(max,se.size());
                    break;
                }
                se.add(s.charAt(j));
            }
            max=Math.max(max,se.size());
        }
        if(max==Integer.MIN_VALUE)
        {
            return s.length();
        }
        return max;
    }
}