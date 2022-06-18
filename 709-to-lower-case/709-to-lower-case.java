class Solution {
    public String toLowerCase(String s) {
        StringBuilder st=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char  c=Character.toLowerCase(s.charAt(i));
            st.append(c);
        }
        return st.toString();
    }
}