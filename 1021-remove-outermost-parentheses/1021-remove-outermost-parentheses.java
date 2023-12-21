class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(st.size()>0)
                {
                    ans.append('(');
                }
                st.push('(');
            }
            else
            {
                st.pop();
                if(st.size()>0)
                {
                    ans.append(')');
                }
                
            }
        }
        return ans.toString();
    }
}