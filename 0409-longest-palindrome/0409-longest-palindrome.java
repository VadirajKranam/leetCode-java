class Solution {
    public int longestPalindrome(String s) {
        Set<Character> st=new HashSet<>();
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(st.contains(s.charAt(i)))
            {
                st.remove(s.charAt(i));
                count++;
            }
            else
            {
                st.add(s.charAt(i));
            }
        }
        if(!st.isEmpty())
        {
            return count*2+1;
        }
        return count*2;
    }
}